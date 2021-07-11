class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : arr)
            map.put(i, map.getOrDefault(i, 0)+1);
        List<Integer> values= new ArrayList(map.values());
        Collections.sort(values);
        int count = values.size();
        for(int a : values){
            if(a <= k){
                k -= a;
                count--;
            }
            if(k < a) break;
        }
        return count;
    }
}