class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         Map<String,List<String>> map = new HashMap<>();
            for(String str : strs){
                char[] c= str.toCharArray();
                Arrays.sort(c);
                String temp = Arrays.toString(c);
                if(!map.containsKey(temp)){
                    map.put(temp,new LinkedList<>());
                }
                map.get(temp).add(str);
            }

             return new ArrayList<>(map.values());
    }
}