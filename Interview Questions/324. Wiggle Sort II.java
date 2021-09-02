class Solution {
    public void wiggleSort(int[] nums) {
      Arrays.sort(nums);
        
        int mid = (nums.length - 1 ) / 2;
        int right = nums.length - 1;
        int[] result = new int[right + 1];
        int counter = 0;
        
        while(mid >= 0 || right > (nums.length - 1 ) / 2 ){        
            if(counter % 2 == 0)
                result[counter] = nums[mid--];
            else 
                result[counter] = nums[right--];
                
            counter++;
        }
        System.arraycopy(result,0,nums,0,nums.length);
    }
}