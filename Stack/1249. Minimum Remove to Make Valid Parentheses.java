class Solution {
    public String minRemoveToMakeValid(String s) {
         Stack<Integer> stack = new Stack<>();
       StringBuilder stringBuilder = new StringBuilder(s); //a)b(c)d"
       for(int i = 1;i<=s.length();i++){
           if(s.charAt(i-1) == '(')
               stack.push(i);
           else if(s.charAt(i-1) == ')' && !stack.empty())
               stack.pop();
           else if(s.charAt(i-1) ==')' && stack.empty()){//))((
               stringBuilder.replace(i-1,i, "0");
           }
       }
      
       while (!stack.empty()){
           stringBuilder.deleteCharAt(stack.pop()-1);
       }
       return stringBuilder.toString().
               replace('0',' ').
               replaceAll("\\s+","");
    }
}