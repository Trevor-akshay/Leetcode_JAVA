class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length < 2)
            return false;
        HashSet<Integer> set = new HashSet<>();
        for(var item : nums)
            if(!set.add(item))
                return true;

        return false   ;
    }
    }

