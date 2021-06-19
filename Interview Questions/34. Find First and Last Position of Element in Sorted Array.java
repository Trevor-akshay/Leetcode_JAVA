class Solution {
    public int[] searchRange(int[] nums, int target) {
      int[] index = new int[2];
      index[0] = binarySearch(nums,target,true);
      index[1] = binarySearch(nums,target,false);
      
      return index;  
    }
    
    private int binarySearch(int[] nums,int target,boolean searchFirst){
        int left = 0;
        int right = nums.length-1;
        int index = -1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                index = mid;
                if(searchFirst)
                    right = mid - 1;
                else
                    left = mid + 1;
            }else if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return index;
    }
}