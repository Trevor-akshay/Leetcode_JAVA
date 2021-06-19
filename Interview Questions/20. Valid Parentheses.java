class Solution {
    public boolean isValid(String s) {
HashMap<Character,Character> maps=new HashMap<>();
        maps.put(')','(');
        maps.put(']','[');
        maps.put('}','{');
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(maps.containsKey(c)){
                if(stack.empty()||stack.pop()!=maps.get(c))return false;
            }
            else
                stack.push(c);
        }
        return stack.empty();
    }
}