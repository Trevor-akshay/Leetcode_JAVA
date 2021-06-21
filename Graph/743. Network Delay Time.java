class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
    Map<Integer,List<int[]>> graph = new LinkedHashMap<>();
        for(int i = 1;i<=n;i++)
            graph.put(i,new ArrayList<>());
        
         for(var time : times)
            graph.get(time[0]).add(new int[]{time[1],time[2]});  

        Map<Integer,Integer> distances = new HashMap<>();
        for(int i=1;i<=n;i++)
            distances.put(i,Integer.MAX_VALUE);
        distances.replace(k,0);

        PriorityQueue<int[]> q = new PriorityQueue<>(
            (a,b) -> a[1] - b[1]  
        );
        q.offer(new int[]{k,0});
        
        while (!q.isEmpty()){
            var poll = q.poll();
            for(var edge : graph.get(poll[0])){
                int distance = poll[1] + edge[1];
                if(distances.get(edge[0]) > distance){
                    distances.replace(edge[0],distance);
                    q.offer(new int[]{edge[0],distance});
                }
            }
        }
        
        int timeTaken = 0;
        for(var value : distances.values()){
            if(value == Integer.MAX_VALUE)
                return -1;
            timeTaken = Math.max(timeTaken,value);
        }

        return timeTaken;
    }

}