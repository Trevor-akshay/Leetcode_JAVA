class Solution {
    public String toLowerCase(String str) {
       char[] input = str.toCharArray();
        
        for(int i = 0; i < input.length; i++) {
            if(input[i] >= 65 && input[i] <= 90) {
                input[i] = (char)(input[i] + 32);
            }
        }
        return new String(input);
    }
}