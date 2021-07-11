class Solution {
    public int removeDuplicates(int[] nums) {
       Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for(int item : nums) {
            if (map.containsKey(item)) {
                if (map.get(item) == 2) continue;
                else map.put(item, map.getOrDefault(item, 0) + 1);
            } else {
                map.put(item, 1);
            }
        }
        for(int item : map.keySet())
            sum+= map.get(item);
        int[] array = new int[sum];
        int k =0;
        for(int item : map.keySet()){
            int count = map.get(item);
            while(count != 0){
                array[k++] = item;
                count--;
            }
        }
        Arrays.sort(array);
        System.arraycopy(array,0,nums,0,array.length);
        return sum;
    }
}