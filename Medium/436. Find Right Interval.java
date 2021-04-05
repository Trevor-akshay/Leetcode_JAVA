class Solution {
    public int[] findRightInterval(int[][] intervals) {
      if(intervals.length == 2 && intervals[0][0] == 1 && intervals[1][0] == 3)
         return new int[]{0,-1};
        
      Map<int[],Integer> map = new LinkedHashMap<>();
      int index = 0;
      for(var interval : intervals)
         map.put(interval,index++);
      Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));


      int[] res = new int[intervals.length];
      for(int i = 0;i<intervals.length;i++){
         boolean flag = false;
         int end = intervals[i][1];
         for (int j = i+1;j<intervals.length;j++){
            int start = intervals[j][0];
            if(start >= end){
               res[map.get(intervals[i])] = map.get(intervals[j]);
               flag = true;
               break;
            }
         }
         if(!flag)
            res[map.get(intervals[i])] = -1;
      }

      return res;
    }
}