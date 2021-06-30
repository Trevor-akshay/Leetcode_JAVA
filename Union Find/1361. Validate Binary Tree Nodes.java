class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Union uf = new Union(n);
        for(int i = 0;i<n;i++){
            var x = leftChild[i];
            var y = rightChild[i];
            
            if(leftChild[i] != -1)
                if(!uf.union(i,leftChild[i]))
                    return false;
            if(rightChild[i] != -1)
                if(!uf.union(i,rightChild[i]))
                    return false;

        }
        
        return uf.count == 1;
    }
   
}

class Union{
    int[][] parent;
    int count;
    public Union(int n){
        count = n;
        parent = new int[n][2];
        for(int i = 0;i<n;i++)
            parent[i] = new int[]{i,0};
    
    }
    
    int find(int u){
        if(u == parent[u][0])
            return u;
        
        return parent[u][0] = find(parent[u][0]);
    }
    
    boolean union(int x,int y){
        parent[y][1]++;
        if(parent[y][1] > 1)
            return false;
        
        int u = find(x);
        int v = find(y);
      
        if(parent[x][0] != u || u == v)
            return false;
        
        count--;
        parent[v][0] = u;
        return true;
    }
}