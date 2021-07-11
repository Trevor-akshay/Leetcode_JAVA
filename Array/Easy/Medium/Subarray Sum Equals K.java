class Solution {
    public int subarraySum(int[] nums, int k) {
int count=0;
        for(int item : nums)
            if(item == k)
                count++;
        for(int i = 0;i<nums.length;i++){//-1
            int sum = nums[i];//1
           for(int j = i+1;j<nums.length;j++){//-1
               sum+=nums[j];//2
                if(sum == k) {
                    count++;
                }
            }
        }
        return count;
		}
		}