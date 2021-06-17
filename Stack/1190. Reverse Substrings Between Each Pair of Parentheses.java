class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();

       for(char c : s.toCharArray()){
           if(c == ')'){
               StringBuilder stringBuilder = new StringBuilder();
               while (stack.peek() != '('){
                   stringBuilder.append(stack.pop());
               }
               stack.pop();
               int i = 0;
               while (i < stringBuilder.length()){
                   stack.push(stringBuilder.charAt(i++));
               }
           }
           else
               stack.push(c);
       }
       StringBuilder stringBuilder = new StringBuilder();
       while (!stack.empty()){
           stringBuilder.append(stack.pop());
       }
       return stringBuilder.reverse().toString();
    }
}