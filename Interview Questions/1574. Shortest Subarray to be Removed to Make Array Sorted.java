class Solution {
    public int findLengthOfShortestSubarray(int[] A) {
        int left = 0;
        int maxSeen = 0;
        while(left < A.length && A[left] >= maxSeen)
            maxSeen = A[left++];
        
        int right = A.length - 1;
        maxSeen = A[right];
        while(right >= 0 && A[right] <= maxSeen)
            maxSeen = A[right--];
        
        int shortestSubArray = Math.min(right + 1,A.length - left);
        if (left == A.length || right == -1) {
            return shortestSubArray;
        }
        
        int leftTemp = 0;
        int rightTemp = right + 1;
        while(leftTemp < left && rightTemp < A.length){
            if(A[rightTemp] >= A[leftTemp]){
                shortestSubArray = Math.min(shortestSubArray,rightTemp - leftTemp - 1);
                leftTemp++;
            }else
                rightTemp++;
        }
        return shortestSubArray;
    }

}