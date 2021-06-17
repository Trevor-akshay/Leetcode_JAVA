class Solution {
    public int calculate(String s) {
      Stack<Integer> stack = new Stack<>();
        stack.push(0);                          // Always keep most recent sum at top
        for (int i = 0, sign = 1; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';    // Be aware of outer loop boundary and i++
                for (; i < s.length() - 1 && Character.isDigit(s.charAt(i + 1)); i++) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                }
                stack.push(stack.pop() + sign * num);
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(sign);
                stack.push(0);
                sign = 1;
            } else if (s.charAt(i) == ')') {    // Update last sum = current sum * sign
                stack.push(stack.pop() * stack.pop() + stack.pop());
            } /* else whitespace*/
        }
        return stack.pop();
    }
}
