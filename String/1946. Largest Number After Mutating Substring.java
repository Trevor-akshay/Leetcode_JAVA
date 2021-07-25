class Solution {
    public String maximumNumber(String num, int[] change) {
        char[] chars = num.toCharArray();
        
        for(int i = 0;i<chars.length;i++){
            int idx = chars[i] - '0';
            if(change[idx] > idx){
                while(i < chars.length && change[idx] >= idx){
                    chars[i] = (char)(change[idx] + '0');
                    i++;
                    if(i < chars.length)
                        idx = chars[i] - '0';
                }
                break;
            }
        }
        return new String(chars);
    }
}