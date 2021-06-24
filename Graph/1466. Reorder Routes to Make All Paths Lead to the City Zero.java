class Solution {
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i = 0 ;i<n; i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int ar[] : connections){
            addEdge(adj, ar[0], ar[1]);
        }
        
        return bfs(adj, n);
    }
    
    
    int bfs(ArrayList<ArrayList<Pair>> adj, int n){
        boolean visited[] = new boolean[n];
        
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        q.add(0);
        
        while(!q.isEmpty()){
            int temp = q.remove();
            visited[temp] = true;
            
            for(Pair p : adj.get(temp)){
                if(!visited[p.v]){
                   // if the edge going away from zero/ nodes connected to 0 and is not fake then count ++
                     if(p.isFake == false) count++; 
                    q.add(p.v);
                }
            }
        }
        
        return count;
    }
    
    
    void addEdge(ArrayList<ArrayList<Pair>> adj, int u, int v){
        adj.get(u).add(new Pair(v, false)); // this is the true edge 

        adj.get(v).add(new Pair(u, true)); // this is the fake edge
    }
}


class Pair{
    int v; // the other node
    boolean isFake = false; // is the edge fake or not
    Pair(int v, boolean isFake){
        this.v = v;
        this.isFake = isFake;
    }
}