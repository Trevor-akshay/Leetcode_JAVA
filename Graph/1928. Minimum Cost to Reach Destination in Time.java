class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        Map<Integer,List<int[]>> map = new HashMap<>();

        for(var edge : edges){
            map.putIfAbsent(edge[0],new ArrayList<>());
            map.putIfAbsent(edge[1],new ArrayList<>());

            map.get(edge[0]).add(new int[]{edge[1],edge[2]});
            map.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        
        int[] distances = new int[passingFees.length];
        Arrays.fill(distances,-1);
        distances[0] = 0;
        
        // 1 -> item , 2 -> time , 3 -> fees
        PriorityQueue<int[]> q = new PriorityQueue<>(
                (a,b) -> a[2] == b[2] ? a[1] - b[1] : a[2] - b[2]
        );        
        q.offer(new int[]{0,0,passingFees[0]});
        
        while (!q.isEmpty()){
            var poll = q.poll();
            
            if(poll[0] == passingFees.length-1)
                return poll[2];
            
            for(var edge : map.get(poll[0])){
                int newDistance = poll[1] + edge[1];
                int newFees = poll[2] + passingFees[edge[0]];
                if(distances[edge[0]] != -1 && distances[edge[0]] <= newDistance)
                    continue;
                
                distances[edge[0]] = newDistance;
                if(newDistance <= maxTime)
                    q.offer(new int[]{edge[0],newDistance,newFees});
            }
        }
        
        return -1;
    }
    
}