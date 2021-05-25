class Solution {
    public int[] decode(int[] A) {
        int n = A.length + 1, a = 0, res[] = new int[n];
        for (int i = 0; i <= n; ++i) {
            a ^= i;
            if (i < n && i % 2 == 1) {
                a ^= A[i];
            }
        }
        res[0] = a;
        for (int i = 0; i < n - 1; ++i) {
            res[i + 1] = res[i] ^ A[i];
        }
        return res;
    }
}