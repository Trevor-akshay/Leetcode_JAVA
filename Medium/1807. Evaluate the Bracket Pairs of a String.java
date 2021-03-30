class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map = new HashMap<>();
        for(int i = 0;i<knowledge.size();i++){
            map.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();){
            char c = s.charAt(i);
            if(c == '('){
                i++;
                StringBuilder tmp = new StringBuilder();
                while(s.charAt(i) != ')'){
                    tmp.append(s.charAt(i++));
                }

                if(map.containsKey(tmp.toString()))
                    sb.append(map.get(tmp.toString()));
                else
                    sb.append("?");
            }
            else
                sb.append(c);
            i++;
        }
        
        return sb.toString();
    }
}