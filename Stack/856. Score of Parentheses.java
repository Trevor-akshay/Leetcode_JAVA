class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); 

        for (char c: S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 + Math.max(2 * temp1, 1));
            }
        }

        return stack.pop();
    }
}