class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer,List<Integer>> g = new HashMap<>();
        build(g,manager);
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{headID,0});
        int time = 0;
        
        while(!q.isEmpty()){
            var poll = q.poll();
            
            time = Math.max(time,poll[1]);
            for(var edge : g.get(poll[0])){
                q.offer(new int[]{edge,poll[1] + informTime[poll[0]]});
            }
        }

        return time;
    }

    private void build(Map<Integer,List<Integer>> g,int[] manager){
        for(int i = 0;i<manager.length;i++)
            g.put(i,new ArrayList<>());
        for(int i = 0;i<manager.length;i++) {
            if (manager[i] != -1)
                g.get(manager[i]).add(i);
        }
    }
}