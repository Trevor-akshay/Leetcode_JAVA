class Solution {
    public int minInsertions(String s) {
      Stack<Character> stack = new Stack<>();
        int result=0;
        int count=0;

        for(char c: s.toCharArray()){
            if(c=='('){
                if(count==1){
                    if(!stack.isEmpty()){
                        result += 1;
                        stack.pop();
                    }
                    else{
                        result += 2;
                    }
                    count=0;
                }
                stack.push(c);
            }
            else if(c==')'){
                count+=1;
                if(count==2){
                    if(!stack.isEmpty())
                        stack.pop();
                    else
                        result += 1;
                    count=0;
                }
            }
        }

        if(count==1){
            if(!stack.isEmpty()){
                result += 1;
                stack.pop();
            }
            else{
                result += 2;
            }
        }

        return result + (stack.size()*2);
    }
}