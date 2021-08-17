class Solution {
    private boolean seen;
    
    public boolean validPath(int n, int[][] edges, int start, int end) {
        boolean[] visited = new boolean[n];
        HashSet<Integer>[] graph = new HashSet[n];
        int i, j;
        
        for(i = 0; i < n; i++){
            graph[i] = new HashSet<Integer>();
        }
        
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            if(graph[start].contains(end)){  // direct connection exists
                return true;
            }
        }
        
        seen = false;
        dfs(graph, visited, start, end);
        return seen;
    }
    
    private void dfs(HashSet<Integer>[] graph, boolean[] visited, int start, int end){
        if(!visited[start] && !seen){
            if(start == end){
                seen = true;
                return;
            }
            
            visited[start] = true;
            for(Integer neighbor : graph[start]){
                dfs(graph, visited, neighbor, end);
            }
        }
    }
}