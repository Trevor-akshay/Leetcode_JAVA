class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        long res = 0;
        Map<Double,Long> counts = new HashMap<>();
        
        for(var rect : rectangles){
            double key = (rect[1] + 0.0)/ (rect[0] + 0.0);
            counts.merge(key,1L,Long::sum);
            res += counts.get(key) - 1;
        }
        
        return res;
    }
}