class Solution {
    public int splitArray(int[] nums, int m) {
        int left = 0;
        int right = 0;
        //left = max of element bcoz cant be less than that.
        //right = total sum.
        for(var num : nums){
            left = Math.max(left,num);
            right += num;
        }
        
        while(left <= right){
            int mid = (left + right) / 2;
            if(isPossible(nums,mid,m)){
                right = mid - 1;
            }else
                left = mid + 1;
        }
        return left;
    }
    
    private boolean isPossible(int[] A,int sum,int m){
        int i = 0;
        
        while(i < A.length){
            int temp = 0;
            while(i < A.length && temp + A[i] <= sum)
                temp += A[i++];
            m--;
            if(m < 0)
                return false;
        }
        
        return true;
    }
}