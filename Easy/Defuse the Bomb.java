class Solution {
    public int[] decrypt(int[] code, int k) {
         int[] res = new int[code.length];
        if (k == 0) return res;
        int start = 1, end = k, sum = 0;
        if (k < 0) {
            k = -k;
            start = code.length - k;
            end = code.length - 1;
        }
        for (int i = start; i <= end; i++) 
            sum += code[i];
        
        for (int i = 0; i < code.length; i++) {
            res[i] = sum;
            sum -= code[(start++) % code.length];
            sum += code[(++end) % code.length];
        }
        return res;
    }
}