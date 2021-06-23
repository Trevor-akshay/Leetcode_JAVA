class Solution {
    Map<Integer,List<double[]>> map = new HashMap<>();
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        for(int i = 0;i<n;i++)
            map.put(i,new ArrayList<>());
        int index = 0;
        for(var edge : edges){
            map.get(edge[0]).add(new double[]{edge[1]+0.0,succProb[index]});
            map.get(edge[1]).add(new double[]{edge[0]+0.0,succProb[index++]});
        }

        Map<Integer,Double> distances = new HashMap<>();
        for(int i = 0;i<n;i++)
            distances.put(i,Double.MIN_VALUE);
        distances.replace(start,0.0);

        PriorityQueue<double[]> q = new PriorityQueue<>(
                Comparator.comparingDouble(a -> -a[1])
        );

        q.offer(new double[]{start+0.0,0.0});
        while(!q.isEmpty()){
            var poll = q.poll();
            if(poll[0] == end)
                return distances.get(end);
            for(var edge : map.get((int)poll[0])){
                double  weight;
                if(poll[1] == 0.0)
                    weight = edge[1];
                else
                    weight = poll[1] * edge[1];

                if(distances.get((int)edge[0]) < weight){
                    distances.put((int)edge[0],weight);
                    q.offer(new double[]{edge[0],weight});
                }
            }
        }
        
        return 0.0;
    }
}