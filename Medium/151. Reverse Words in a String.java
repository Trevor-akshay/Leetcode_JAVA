class Solution {
    public String reverseWords(String s) {
        StringBuilder S = new StringBuilder();
        for(int i = s.length()-1;i>=0;i--){
            StringBuilder temp = new StringBuilder();
            while (i >= 0 && s.charAt(i) != ' '){
                temp.insert(0,s.charAt(i--));
            }
            if(temp.length() != 0)
                S.append(temp).append(" ");
        }
        return S.deleteCharAt(S.length()-1).toString();
    }
}