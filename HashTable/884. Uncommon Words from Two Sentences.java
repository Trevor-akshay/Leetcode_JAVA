class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String,Integer> map = new HashMap<>();

        for(String words : A.split(" ")){
            map.put(words,map.getOrDefault(words,0)+1);
        }
        for(String words : B.split(" ")){
            map.put(words,map.getOrDefault(words,0)+1);
        }

        List<String> result = new ArrayList<>();
        for(var entry : map.keySet()){
            if(map.get(entry) == 1)
                result.add(entry);
        }

        return result.toArray(String[]::new);
    }
}