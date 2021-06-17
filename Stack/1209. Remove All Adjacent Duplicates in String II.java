class Solution {
  private class Count {
        char c;
        int  count;
        Count(char c, int count){
            this.c = c;
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k) {
        if(s == null || s.length() == 0 || k == 0 || k > s.length()) return s;
        char[] sc = s.toCharArray();
        Stack<Count> stack = new Stack<>();
        int count = 0;
        
        for(int i = 0; i < sc.length; i++){
            if(stack.isEmpty()) stack.push(new Count(sc[i], 1));
            else{
                if(stack.peek().c != sc[i]){
                    stack.push(new Count(sc[i], 1));
                }else{
                    int curCount = stack.peek().count;
                    stack.push(new Count(sc[i], curCount + 1));
                }
            }
			
            // Pop them up when we get enough repeated characters
            if(stack.peek().count == k){
                for(int j = 0; j < k; j++){
                    stack.pop();
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop().c);
        }
        return sb.reverse().toString();
    }
}