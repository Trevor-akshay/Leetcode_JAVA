class Solution {
    public int minCost(String s, int[] cost) {
        int minCost = 0;
        int i = 0;
        while(i < s.length() - 1){
            if(s.charAt(i) == s.charAt(i + 1)){
                int max = 0;
                char c = s.charAt(i);
                int tempCost = 0;
                while(i < s.length() && c == s.charAt(i)){
                    tempCost += cost[i];
                    max = Math.max(max,cost[i]);
                    i++;
                }
                minCost += tempCost - max;
            }
            else
                i++;
        }
        return minCost;
    }
}