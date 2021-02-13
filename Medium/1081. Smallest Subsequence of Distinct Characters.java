class Solution {
    public String smallestSubsequence(String s) {
    
      Deque<Character> stack = new LinkedList<>();
       Map<Character,Integer> freq = new HashMap<>();
       for(char c : s.toCharArray())
           freq.put(c,freq.getOrDefault(c,0)+1);

       for(char c : s.toCharArray()){//abacb"
           if(!stack.isEmpty() && stack.contains(c)) {
               freq.put(c,freq.get(c)-1);
               continue;
           }
           while (!stack.isEmpty() && c <= stack.peek()
               && freq.get(stack.peek()) > 1){
                   freq.put(stack.peek(),freq.get(stack.pop())-1);
               }
               stack.push(c);
               }
       StringBuilder stringBuilder = new StringBuilder();
       while (!stack.isEmpty()){
           stringBuilder.append(stack.pop());
       }
       return stringBuilder.reverse().toString();
    }
}
    
