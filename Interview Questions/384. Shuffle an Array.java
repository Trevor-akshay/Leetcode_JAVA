class Solution {
  int result [];
    public Solution(int[] nums) {
        result = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return result;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
       int temp[] = result.clone();
        Random random = new Random();
        int i = 0;
        while (i < temp.length){
            int value = random.nextInt(temp.length);
            int cache = temp[value];
            temp[value] = temp[i];
            temp[i] = cache;
            i++;
            }
        return temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */