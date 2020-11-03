class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
         List<Integer> list = new ArrayList<>();
        for (int item : nums)
            list.add(item);
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                list.add(sum);
            }
        }
        Collections.sort(list);
        long value = 0;
        for (int i = left-1; i < right; i++) {
            value += list.get(i);
        }
        return (int)(value%(Math.pow(10,9)+7));
    }
}