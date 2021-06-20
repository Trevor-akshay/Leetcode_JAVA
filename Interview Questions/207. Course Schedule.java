class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] dependencies = new int[numCourses];
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int i = 0;i<prerequisites.length;i++) {
            dependencies[prerequisites[i][0]]++;
            map.putIfAbsent(prerequisites[i][1],new HashSet<>());
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0;i<dependencies.length;i++)
            if(dependencies[i] == 0)
                queue.offer(i);

        int count = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            for (int i = 0;i<n;i++){
                var poll = queue.poll();
                count++;
                if(map.get(poll) == null)
                    continue;
                Set<Integer> temp = map.get(poll);
                for(var depends : temp){
                    dependencies[depends]--;
                    if(dependencies[depends] == 0)
                        queue.offer(depends);
                }
            }
        }

        return count == numCourses;
}
}