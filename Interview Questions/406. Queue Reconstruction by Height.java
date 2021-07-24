class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b) -> b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new ArrayList<>();
        for(var p : people){
            list.add(p[1],p);
        }
        
        return list.toArray(new int[list.size()][]);
                    
    }
}