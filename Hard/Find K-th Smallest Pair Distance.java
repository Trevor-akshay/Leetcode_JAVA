class Solution {
	public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int minK = 0, maxK = nums[nums.length - 1] - nums[0];
        
		
        while (minK < maxK) {
            int mid = (minK + maxK) / 2;
            int count = 0, left = 0;
            
            
            for (int right = 1; right < nums.length; right++) {
                while (true) {
                    int diff = nums[right] - nums[left];
                    if(diff > mid) left++;
                    else break;
                }
              
                count += right - left;
            }
            
            if (count >= k) maxK = mid;
            else minK = mid + 1;
        }
        return minK;}}
