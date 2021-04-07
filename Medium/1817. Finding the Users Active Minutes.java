class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];
        Map<Integer,Set<Integer>> map = new HashMap<>();
        
        for(int i = 0;i<logs.length;i++){
            map.putIfAbsent(logs[i][0],new HashSet<>());
            map.get(logs[i][0]).add(logs[i][1]);
        }
        for(var item : map.keySet()){
            int size = map.get(item).size();
            res[size-1] += 1;
        }
            
        return res;
    }
}