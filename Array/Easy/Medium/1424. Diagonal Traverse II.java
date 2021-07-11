class Solution {
        public int[] findDiagonalOrder(List<List<Integer>> nums) {
      List<List<Integer>> lists = new ArrayList<>();
        int length = 0;
        for (int i = 0; i < nums.size(); ++i) {
            length += nums.get(i).size();
            for (int j = 0; j < nums.get(i).size(); ++j) {
                int idx = i + j;
                while (idx >= lists.size()) {
                    lists.add(new ArrayList<>());
                }
                lists.get(idx).add(nums.get(i).get(j));
            }
        }
        int[] result = new int[length];
        int k = 0;
        for (int i = 0; i < lists.size(); ++i) {
            for (int j = lists.get(i).size() - 1; j >= 0; --j) {
                result[k++] = lists.get(i).get(j);
            }
        }
        return result;
    }
}