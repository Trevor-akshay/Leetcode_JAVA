class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0')
            return 0;
        Integer[] memo = new Integer[s.length()];
        return helper(0,s,memo);
    }
    
    private int helper(int index,String s,Integer[] memo){
        if(index == s.length())
            return 1;
        if(memo[index] == null){
            int count = 0;
            for(int i = index + 1;i<=s.length();i++){
                String temp = s.substring(index,i);
                int value = Integer.parseInt(temp);
            if(value > 26 || temp.charAt(0) == '0')
                break;
            count += helper(i,s,memo);
            }
            memo[index] = count;
        }
        
        return memo[index];
    }
}