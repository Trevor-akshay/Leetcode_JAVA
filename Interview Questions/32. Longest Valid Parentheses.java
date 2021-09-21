class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == '(')
                stack.push(i);
            else{
                stack.pop();
                if(stack.empty())
                    stack.push(i);
                maxLen = Math.max(maxLen,i - stack.peek());
            }
            i++;
        }
        return maxLen;
    }
}