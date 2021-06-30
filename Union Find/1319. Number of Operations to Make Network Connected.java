class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1)
            return -1;
        int[] parent = new int[n];
        for(int i = 0;i<n;i++){
            parent[i] = i;
        }
        int components = n;
        for(var c : connections){
            int x = find(c[0],parent);
            int y = find(c[1],parent);
            if(x != y){
                parent[y] = x;
                components--;
            }
        }
        
        return components-1;
    }
    
    private int find(int u,int[] parent){
        if(parent[u] == u)
            return u;
        return parent[u] = find(parent[u],parent);
    }
}