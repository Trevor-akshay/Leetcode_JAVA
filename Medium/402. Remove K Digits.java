class Solution {
    public String removeKdigits(String num, int k) {
       if (k == num.length() || k > num.length()) return "0";
        Stack<Character> stack = new Stack<>();

        for(char c : num.toCharArray()){
            while (!stack.empty() && k >0 && stack.peek() > c){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (k>0){
            stack.pop();
            k--;
        }
        StringBuilder result = new StringBuilder();
        while (!stack.empty())
            result.append(stack.pop());
         for(int i =result.length()-1;i>=0;i--){
            if(result.charAt(i) == '0')
                result.deleteCharAt(i);
            else break;
        }
        if(result.toString().equals("")) return "0";

        return result.reverse().toString();
    }
}