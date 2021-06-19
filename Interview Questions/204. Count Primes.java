class Solution {
    public int countPrimes(int n) {
       int ans = 0;
        boolean[] np = new boolean[n + 1];
        for (int i = 2; i < Math.sqrt(n); ++i) {
            if (!np[i]) {
                for (int j = i * i; j < n; j += i) {
                    np[j] = true;
                }
            }
        }
        for (int i = 2; i < n; ++i) {
            if (!np[i]) {
                ++ans;
            }
        }
        return ans;
    }
}