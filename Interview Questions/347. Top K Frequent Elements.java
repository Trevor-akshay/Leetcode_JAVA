class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int item : nums) {
            freq.put(item, freq.getOrDefault(item, 0) + 1);
        }
        Map<Integer,Integer> sortedMap = freq.entrySet().
                stream().
                sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e2, LinkedHashMap::new));
    
        int[] result = new int[k];
        int i = 0;
        for(int item:sortedMap.keySet()){
            if(i== result.length) break;
            result[i++] = item;
        }
        return result;
    }
}