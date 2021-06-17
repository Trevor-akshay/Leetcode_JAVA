class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
         Stack<Integer> stack = new Stack<>();
        int index = 0;
       for(int item : pushed){
           stack.push(item);
           while (!stack.empty() && stack.peek() == popped[index]){
               stack.pop();
               index++;
           }
       }
       return stack.empty();
    }
}