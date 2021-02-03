class Solution {
    public String makeGood(String s) {
        if(s.length() == 1) return s;
       Stack<Character> stack = new Stack<>();

       for(char ch : s.toCharArray()){
           if(stack.empty())
               stack.push(ch);
           else{
               char value = stack.peek();
               if(Character.toUpperCase(value) == Character.toUpperCase(ch) 
                  && value != ch)
                   stack.pop();
               else
                   stack.push(ch);
           }
       }
       StringBuilder stringBuilder = new StringBuilder();
       while (!stack.empty()){
           stringBuilder.append(stack.pop());
       }
       return stringBuilder.reverse().toString();
    }
}