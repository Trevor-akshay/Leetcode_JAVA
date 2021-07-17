class Solution {
    boolean found = false;
    public int[] constructDistancedSequence(int n) {
         boolean[] visited = new boolean[n+1];

            int[] result = new int[n * 2 - 1];
            helper(result,visited,0,n);

            return result;
        }
    private boolean helper(int[] res,boolean[] visited,int pos,int n){
            if(pos == res.length)
                return true;
        
            if(res[pos] != 0)
                return helper(res,visited,pos+1,n);

            for(int i = n;i>0;i--){
                if(!visited[i] && (i == 1 || pos + i < res.length && res[pos + i] == 0)) {
                    res[pos] = i;
                    if(i != 1)
                        res[pos + i] = i;
                    visited[i] = true;
                    if (helper(res, visited, pos + 1, n))
                        return true;

                    res[pos] = 0;
                    if (i != 1)
                        res[pos + i] = 0;
                    visited[i] = false;
                }
                }

        return false;
    }
}
