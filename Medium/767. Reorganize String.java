class Solution {
    public String reorganizeString(String S) {
       Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i = 0;i<S.length();i++)
            map.merge(S.charAt(i),1,Integer::sum);
        
        PriorityQueue<Map.Entry<Character,Integer>> q = new PriorityQueue<>(
                (a,b) -> b.getValue() - a.getValue()
        );
        for(var val : map.entrySet())
            q.offer(val);
        
        StringBuilder result = new StringBuilder();
        while (!q.isEmpty()){
            Map.Entry<Character,Integer> temp = q.poll();
            Map.Entry<Character,Integer> temp1 = q.poll();
            if(result.length() == 0 || result.charAt(result.length()-1) != temp.getKey()){
                result.append(temp.getKey());
                if(temp.getValue() != 1)
                    q.offer(Map.entry(temp.getKey(),temp.getValue()-1));
            }
            else
                return "";
            if(temp1 != null){
                if(result.charAt(result.length()-1) != temp1.getKey()){
                    result.append(temp1.getKey());
                    if(temp1.getValue() != 1)
                        q.offer(Map.entry(temp1.getKey(),temp1.getValue()-1));
                }else
                    return "";
            }
        }
        return result.toString();
    }
}