class Solution {
   public int findMaxValueOfEquation(int[][] points, int k) {
        int max = Integer.MIN_VALUE;
        int i = 0,j=1;
        while(i<points.length && j<points.length){
            int value = Math.abs(points[i][0] - points[j][0]);
            if(value <= k){
                max = Math.max(max,(points[i][1]+points[j][1] + value));
            }
            j++;
            if(j== points.length){
                i++;
                j=i+1;
            }
        }
        return max;
    }
}