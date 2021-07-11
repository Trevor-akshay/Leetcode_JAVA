class Solution {
    public int[][] merge(int[][] intervals) {
    if(intervals.length == 1)
             return intervals;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int[] interval = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= interval[1])
                interval[1] = Math.max(intervals[i][1], interval[1]);
            else {
                list.add(interval);
                interval = intervals[i];
            }
        }
        list.add(interval);
        return list.toArray(new int[][]{});
    }
}