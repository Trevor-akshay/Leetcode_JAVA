class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int count  = 0;
        int left = 0,right = 0;
        int temp = 0;
        while (right < A.length){ // 2  1  4  3
            if(A[right] >= L && A[right] <= R){
                temp = right-left+1;// 2
            }
            else if(A[right] > R){
                left = right+1;
                temp = 0;
            }
            count +=temp;
            right++;
        }
        return count;
}
}