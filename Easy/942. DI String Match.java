class Solution {
    public int[] diStringMatch(String S) {
        int[] result = new int[S.length()+1];
        int index = 0;
        int increasing = 0;int decreasing = S.length();
        for(char c : S.toCharArray()){
            if(c == 'I')
                result[index++] = increasing++;
            else
                result[index++] = decreasing--;
        }
       
        
        result[index] =(S.charAt(S.length()-1) == 'I') ? increasing : decreasing ;
        return result;
    }
}