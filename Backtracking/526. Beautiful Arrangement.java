class Solution {
    int beautifulArrangements = 0;
    public int countArrangement(int n) {
        helper(n,new boolean[n+1],1);
        
        return beautifulArrangements;
    }

    private void helper(int n,boolean[] visited,int position){
        if (position > n) {
            beautifulArrangements++;
            return;
        }
        for (int i = 1; i <= n; i++) {
           if (!visited[i] && (i % position == 0 || position % i == 0)) {
                visited[i] = true;
                helper(n,visited,position+1);
                visited[i] = false;
            }
        }
}
}