class Solution {
    Map<Integer,List<Integer>> map = new HashMap<>();
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        for(int i = 0;i<n;i++)
            map.put(i,new ArrayList<>());
        
        for(var edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        int[] result = new int[n];
        int times = 1;
        for(int i = 0;i<n;i++){
            Queue<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[n];
            q.offer(i);
            var distance = 0;
            while(!q.isEmpty()){
                int N = q.size();
                int temp = 0;
                for(int j = 0;j<N;j++){
                    var poll = q.poll();
                    visited[poll] = true;
                    for(var edge : map.get(poll)){
                        if(!visited[edge]){
                             q.offer(edge);
                             temp++;
                        }
                    }
               }
               distance += temp * times;
               times++;
            }
            result[i] = distance;
            times = 1;
        }
        
        return result;
    }
}