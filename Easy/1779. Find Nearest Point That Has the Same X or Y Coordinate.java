class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
     int index = -1; 
        for (int i = 0, smallest = Integer.MAX_VALUE; i < points.length; ++i) {
            int dx = x - points[i][0], dy = y - points[i][1];
            if (dx * dy == 0 && Math.abs(dy) + Math.abs(dx) < smallest) {
                smallest = Math.abs(dx) + Math.abs(dy);
                index = i;
            }
        }
        return index;
    }
}