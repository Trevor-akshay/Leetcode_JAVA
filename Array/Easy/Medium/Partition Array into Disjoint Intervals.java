class Solution {
    public int partitionDisjoint(int[] A) {
     int result = 0;
        int max= A[0];
        int currMax = A[0];
        for(int i =1;i<A.length;i++){
            if(A[i] < max){
                result = i;
                max = currMax;
            }
            currMax = Math.max(currMax, A[i]);
        }
        return result+1;
    }
}