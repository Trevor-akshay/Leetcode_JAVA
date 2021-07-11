class Solution {
    public int minSetSize(int[] arr) {
         if(arr.length < 3) return 1;

        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int item : arr)
            map.put(item,map.getOrDefault(item,0)+1);

        if(map.size() == 1) return 1;

        Map<Integer,Integer> sortedMap = new LinkedHashMap<>();

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(value -> sortedMap.put(value.getKey(),value.getValue()));
        int arrayhalf = arr.length/2;
        Outer : for(int item : sortedMap.keySet()){
            int count = sortedMap.get(item);
            while(count > 0){
                if(arrayhalf == 0)
                    break Outer;
                set.add(item);
                count--;
                arrayhalf--;
            }
        }
        return set.size();
    }
}