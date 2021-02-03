class Solution {
    public String removeDuplicates(String S) {
       StringBuilder sb = new StringBuilder();
        int index = 0;
       for(char ch : S.toCharArray()){
           if(sb.length() == 0){
               sb.append(ch);
           }
           else{
               if(sb.charAt(index-1) == ch){
                   sb.deleteCharAt(index-1);
               }
               else{
                   sb.append(ch);
               }
           }
		   index = sb.length();

           }
        return sb.toString();
    }
}