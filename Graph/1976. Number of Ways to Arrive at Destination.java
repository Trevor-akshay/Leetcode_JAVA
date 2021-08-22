class Solution {
    public int countPaths(int n, int[][] roads) {
        Map<Integer,List<int[]>> graph = new HashMap<>();
        buildGraph(graph,roads);
        int[] distances = new int[n];
        long[] dp = new long[n];
        Arrays.fill(distances,Integer.MAX_VALUE);
        distances[0] = 0;
        dp[0] = 1;
        //0 = end , 1 = distance
        PriorityQueue<int[]> q = new PriorityQueue<>(
                (a,b) -> a[1] - b[1]
        );
        q.offer(new int[]{0,0});
        while (!q.isEmpty()){
            var poll = q.poll();
            if(graph.get(poll[0]) == null)
                continue;
            for(var edge : graph.get(poll[0])){
                var node = edge[0];
                int newDistance = poll[1] + edge[1];
                if(distances[node] > newDistance){
                    q.offer(new int[]{node,newDistance});
                    dp[node] = dp[poll[0]];
                    distances[node] = newDistance;
                }else if(newDistance == distances[node]){
                    dp[node] = (dp[node] + dp[poll[0]]) % (int)(1e9 + 7);
                }
                }
            }
        
        return (int)(dp[n-1] % (int)(1e9 + 7));
    }

    private void buildGraph(Map<Integer,List<int[]>> graph,int[][] edges){
        for(var edge : edges){
            graph.putIfAbsent(edge[0],new ArrayList<>());
            graph.putIfAbsent(edge[1],new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
    }

}