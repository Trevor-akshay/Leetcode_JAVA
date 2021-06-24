class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(0,visited,rooms);
        return visited.size() == rooms.size();
    }
    
    private void dfs(int node,Set<Integer> visited,List<List<Integer>> list){
        visited.add(node);
        
        for(var room : list.get(node)){
            if(!visited.contains(room))
                dfs(room,visited,list);
        }
    }
}