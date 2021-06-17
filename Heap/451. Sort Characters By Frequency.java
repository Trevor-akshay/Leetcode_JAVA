class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i = 0;i<s.length();i++)
            map.merge(s.charAt(i),1,Integer::sum);
        
        PriorityQueue<Map.Entry<Character,Integer>> q = new PriorityQueue<>(
                (a,b) -> b.getValue() - a.getValue()
        );
        for(var item : map.entrySet()){
            q.offer(item);
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        while (!q.isEmpty()){
            int val = q.peek().getValue();
            char c = q.poll().getKey();
            while (val-- != 0)
                stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}