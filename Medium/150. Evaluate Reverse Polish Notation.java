class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
       for(String str : tokens){
           switch (str){ // 2  1  +  3  * = 9
               case "+":{
                   int value = stack.pop();
                   stack.push(stack.pop() + value);
                   break;
               }
               case "-":{
                   int value = stack.pop();
                   stack.push(stack.pop() - value);
                   break;
               }
               case "*":{
                   int value = stack.pop();
                   stack.push(stack.pop() * value);
                   break;
               }
               case "/":{
                   int value = stack.pop();
                   stack.push(stack.pop() / value);
                   break;
               }
               default:{
                   stack.push(Integer.parseInt(str));
                   break;
               }
           }
       }
       return stack.pop();
    }
}