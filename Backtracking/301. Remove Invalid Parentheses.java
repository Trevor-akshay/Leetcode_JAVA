class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();

        Queue<String> q = new ArrayDeque();
        q.offer(s);
        
        Set<String> visit = new HashSet<>();
        visit.add(s);
        
        boolean level = false;
        
        while (!q.isEmpty())  {
            s = q.poll();
            if (isValid(s)){
                list.add(s);
                level = true;
            }
            if(level)
                continue;
            
            for (int i = 0; i < s.length(); i++){
                if (Character.isAlphabetic(s.charAt(i)))
                    continue;
 
                String temp = s.substring(0, i) + s.substring(i + 1);
                if (!visit.contains(temp)){
                    q.add(temp);
                    visit.add(temp);
                }
            }
          }
            
        return list;
    }
    
    private boolean isValid(String s){
        int count = 0;
        for(char c : s.toCharArray()){
            count = c == '(' ? count + 1 : c == ')' ? count - 1 : count;
            if(count < 0)
                return false;
        }
        
        return count == 0;
    }
   
}