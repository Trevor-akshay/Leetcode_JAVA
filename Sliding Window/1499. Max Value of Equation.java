class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
       int max = Integer.MIN_VALUE;
        int l = 0;
        int r = 1;
        while(l<points.length-1&&r<points.length){
            if(Math.abs(points[r][0]-points[l][0]) <= k){
                max = Math.max(points[r][1]+points[l][1]+Math.abs(points[r][0]-points[l][0]),max);
                if(r<points.length-1){
                    r++;
                    if(points[r-1][1]-points[r-1][0]>points[l][1]-points[l][0]&&r-1!=l)
                        l=r-1;
                }
                else{
                    l++;
                }
            }
            else{
                l++;
                if(l == r && r < points.length-1)
                        r++;
            }
        }        
        return max;
    }
}