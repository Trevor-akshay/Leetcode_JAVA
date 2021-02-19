class Solution {
    public String frequencySort(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<Character,Integer> freq = new HashMap<>();

        for(char c: s.toCharArray())
            freq.put(c,freq.getOrDefault(c,0)+1);

        Map<Character,Integer> sortedMap = new LinkedHashMap<>();

        freq.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                forEachOrdered(value -> sortedMap.put(value.getKey(),value.getValue()));

        for(var item : sortedMap.keySet()){
            int temp = sortedMap.get(item);
            while (temp-- !=0){
            stringBuilder.append(item);
            }
        }
        return stringBuilder.toString();
    }
}