class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] cirNums = new int[nums.length * 2];

       for(int i = 0;i<nums.length;i++){
           cirNums[i+nums.length] = cirNums[i] = nums[i];
       }
       Stack<Integer> stack = new Stack<>();
       for(int i = cirNums.length-1;i>=0;i--){
           if(stack.empty()){
               stack.push(cirNums[i]);
              
           }
           else{ 
               while (!stack.empty() && stack.peek() <= cirNums[i]){
                   stack.pop();
               }
               int value = cirNums[i];
               if(!stack.empty())
                    cirNums[i] =stack.peek();
               else
                   cirNums[i] = -1;
               stack.push(value);
               }
       }
       System.arraycopy(cirNums,0,nums,0,nums.length);

       return nums;
    }
}