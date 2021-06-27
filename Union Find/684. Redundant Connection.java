class Solution {    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Union uf = new Union(n+1);
        for(int i = 0;i<n;i++){
            if(!uf.union(edges[i][0],edges[i][1]))
                return edges[i];
        }
        
        return null;
    }
}

class Union{
        int[] parent;
        public Union(int n){
            parent = new int[n];
            for(int i = 0;i<n;i++)
                parent[i] = i;
        }
        
        public int find(int u){
            if(u == parent[u])
                return u;
            return parent[u] = find(parent[u]);
        }
        
        public boolean union(int x,int y){
            x = find(x);
            y = find(y);
            
            if(x == y)
                return false;
            
            parent[y] = x;
            return true;
        }
    }