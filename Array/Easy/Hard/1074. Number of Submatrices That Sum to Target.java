class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefixSum = new int[m + 1][n + 1];
        int targetSubMatrix = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = matrix[i - 1][j - 1] + prefixSum[i][j - 1];
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int startCol = 0; startCol < n; startCol++) {
            for (int endCol = startCol + 1; endCol <= n; endCol++) {
                map.clear();
                map.put(0, 1);
                int sum = 0;
                for (int row = 1; row <= m; row++) {
                    sum += (prefixSum[row][endCol] - prefixSum[row][startCol]);
                    targetSubMatrix += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return targetSubMatrix;
    }
}