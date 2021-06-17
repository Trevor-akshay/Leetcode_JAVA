class Solution {
    public int minAddToMakeValid(String S) {
         int res = 0;
       Stack<Character> stack = new Stack<>();
       for(char c : S.toCharArray()){
           if(c == '('){
               stack.push(c);
           }
           else{
               if(stack.empty())
                   res++;
               else
                   stack.pop();
           }
       }
       return res+stack.size();
    }
}