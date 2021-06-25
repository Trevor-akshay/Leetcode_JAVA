class Solution {
    public List<String> letterCasePermutation(String s) {
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        
        for(int i = 0;i<s.length();i++){
            int n = q.size();
            for(int j = 0;j<n;j++){
                var temp = q.poll();
                char[] chars = temp.toCharArray();
                if(Character.isDigit(chars[i]))
                    q.offer(new String(chars));
                else{
                    chars[i] = (char)(chars[i] | ' ');
                    q.offer(new String(chars));
                    chars[i] = (char)(chars[i] & '_');
                    q.offer(new String(chars));
                }
            }
        }
        
        return new ArrayList<>(q);
    }
}