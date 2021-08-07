class NumArray {
    int[] nums;
    int n;
    int[] segments;

    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        build();
    }
    
    private void build(){
        int height = (int)(Math.log(n)/Math.log(2)) + 1;
        int maxSize = 2 * (int)(Math.pow(2,height) - 1);
        segments = new int[maxSize]; 
        buildHelper(0,0,n-1);
    }
    
    private int buildHelper(int index,int left,int right){
        if(left == right){
            segments[index] = nums[left];
            return segments[index];
        }
        int mid = (left + right) / 2;
        segments[index] = buildHelper(index * 2 + 1,left,mid) + 
                        buildHelper(index * 2 + 2,mid + 1,right);
        return segments[index];
    }
    
     public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        updateHelper(0,0,n-1,index,diff);
    }
    
    private void updateHelper(int index,int left,int right,int updateIndex,int diff){
         if(left > updateIndex || right < updateIndex)
            return;
        segments[index] += diff;
        if(left != right){
            int mid = (left + right) / 2;
            updateHelper(index * 2 + 1,left,mid,updateIndex,diff);
            updateHelper(index * 2 + 2,mid + 1,right,updateIndex,diff);
        }
    }
    
    public int sumRange(int left, int right) {
        return sumRangeHelper(0,0,n-1,left,right);
    }
    
    private int sumRangeHelper(int index,int left,int right,int leftRange,int rightRange){
       if(right < leftRange) {
            return 0;
        }
        if(left == right) {
            if(left >= leftRange && right <= rightRange)
                return segments[index];
            return 0;
        }

        if(left >= leftRange && right <= rightRange) {
            return segments[index];
        }
        
        int mid = (left + right) / 2;
        return sumRangeHelper(index * 2 + 1,left,mid,leftRange,rightRange) + 
            sumRangeHelper(index * 2 + 2,mid + 1,right,leftRange,rightRange);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */