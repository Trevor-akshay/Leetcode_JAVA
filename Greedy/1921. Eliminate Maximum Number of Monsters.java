class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Double> q = new PriorityQueue<>();
        
        for(int i = 0;i<speed.length;i++){
            q.offer((dist[i] * 1.0) / speed[i]);
        }
        
        int eli = 0;
        double min = 0.0;
        while(!q.isEmpty() && q.poll() > min){
            min++;
            eli++;
        }
        
        return eli;
    }
}