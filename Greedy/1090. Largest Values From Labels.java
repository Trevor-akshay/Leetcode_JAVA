class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int[][] ar = new int[values.length][2];
        
        for(int i = 0;i<values.length;i++){
            ar[i][0] = values[i];
            ar[i][1] = labels[i];
        }
        
        Map<Integer,Integer> freq = new HashMap<>();
        Arrays.sort(ar,(a,b) -> b[0] - a[0]);
        int max = 0;

        for(int[] num : ar){
            if(num_wanted == 0)
                break;
            if(!freq.containsKey(num[1]) || freq.get(num[1]) < use_limit){
                max += num[0];
                num_wanted--;
            }
            freq.put(num[1],freq.getOrDefault(num[1],0) + 1);
        }

        return max;
    }
}