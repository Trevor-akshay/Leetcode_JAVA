class Solution {
    public int[] processQueries(int[] queries, int m) {
        List<Integer> P = new ArrayList<>();
        int[] output = new int[queries.length];
        for(int i = 1;i<=m;i++)
            P.add(i);
        for(int i = 0;i<queries.length;i++) {
            int temp = P.indexOf(queries[i]);
            output[i] = temp;
            P.remove(temp);
            P.add(0,queries[i]);
        }
        //System.out.println(P);
        return output;
    }
}