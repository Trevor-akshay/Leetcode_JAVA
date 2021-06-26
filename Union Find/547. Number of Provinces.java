class Solution {
     private class Subset{
         int parent[];
         int count;

        public Subset(int n) {
            parent = new int[n];
            count = n;
            for(int i = 0 ;i<n;i++){
                parent[i] = i;
            }
        }
        public int find(int u){
             if(u == parent[u])
                return u;

            return parent[u] = find(parent[u]);
        }

        public void union(int x,int y){
            x = find(x);
            y = find(y);

            if(x == y)
                return;
        
            parent[y] = x;
            count--;
        }
         
         public int getCount(){
             return count;
         }
         
        public String toString(){
            return parent+"";
        } 
    }
    public int findCircleNum(int[][] isConnected) {
         int n = isConnected.length;
         Subset s = new Subset(n);
         for(int i = 0;i<n;i++){
             for(int j = 0;j<n;j++){
                 if(i != j && isConnected[i][j] == 1)
                    s.union(i,j);
             }
         }
         
         return s.getCount();   
    }
}