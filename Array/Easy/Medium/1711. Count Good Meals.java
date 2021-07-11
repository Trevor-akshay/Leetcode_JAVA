class Solution {
    public int countPairs(int[] deliciousness) {
        long result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<deliciousness.length; i++){
            for(int j=0; j<=21; j++){
                int key = (int)Math.pow(2, j);
                int value = key - deliciousness[i];
                result = (result + map.getOrDefault(value, 0));
            }
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0)+1);
        }
        return (int)(result%(Math.pow(10,9)+7));
    }
}