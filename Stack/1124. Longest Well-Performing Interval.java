class Solution {
    public int longestWPI(int[] hours) {
      HashMap<Integer, Integer> map = new HashMap();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < hours.length; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (!map.containsKey(sum)) map.put(sum, i);
            if (sum > 0) max = i+1;
            else if (map.containsKey(sum - 1)) {
                max = Math.max(max, i - map.get(sum-1));
            }
        }
        return max;
    }
}