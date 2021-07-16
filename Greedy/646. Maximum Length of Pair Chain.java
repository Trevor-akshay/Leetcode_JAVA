class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b) -> a[1] - b[1]);
        
        int len = 1;
        int temp = pairs[0][1];
        for(int i = 1;i<pairs.length;i++){
            if(temp < pairs[i][0]){
                len++;
                temp = pairs[i][1];
            }
        }
        
        return len;
    }
}