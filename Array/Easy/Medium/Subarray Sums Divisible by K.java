class Solution {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap();

        int sum = 0;
        map.put(0, 1);
        int res = 0;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            int cur = Math.floorMod(sum, K);
            res += map.getOrDefault(cur, 0);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        return res;
    }
}