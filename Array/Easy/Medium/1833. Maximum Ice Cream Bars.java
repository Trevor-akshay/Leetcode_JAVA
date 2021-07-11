class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ice = 0;
        
        for(var cost : costs){
            if(cost > coins)
                break;
            coins -= cost;
            ice++;
        }
        
        return ice;
    }
}