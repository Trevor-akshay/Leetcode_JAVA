class Solution {
    public List<List<Integer>> groupThePeople(int[] g) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int n = g.length;
        for(int i = 0;i<n;i++){
            map.putIfAbsent(g[i],new ArrayList<>());
            map.get(g[i]).add(i);
            if(map.get(g[i]).size() == g[i]){
                result.add(map.get(g[i]));
                map.replace(g[i],new ArrayList<>());
            }
        }

        return result;
    }
}