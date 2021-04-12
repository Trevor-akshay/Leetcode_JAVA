class Solution {
    public int[][] kClosest(int[][] points, int k) {
       PriorityQueue<int[]> q = new PriorityQueue<>(
                (a,b) -> getDist(b) - getDist(a)
        );
        for(int[] point : points){
            if(q.size() < k)
                q.offer(point);
            else if(getDist(q.peek()) > getDist(point)){
                q.poll();
                q.offer(point);
            }
        }
        int[][] res = new int[k][2];
        int index = 0;
        while (!q.isEmpty()){
            res[index++] = q.poll();
        }
        return res;
    }
    private int getDist(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}