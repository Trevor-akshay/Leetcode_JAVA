class Solution {
    public String largestNumber(int[] array) {
       String[] nums = new String[array.length];
        int index = 0;
        for(var num : array)
            nums[index++] = num+"";

        Arrays.sort(nums,(a,b) -> (a+b).compareTo(b+a));
        if(nums[nums.length-1].equals("0"))
            return "0";
        
        StringBuilder s = new StringBuilder();
        for(int i = array.length-1;i>=0;i--){
            s.append(nums[i]);
        }
        return s.toString();
    }
    
}