class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] helper = new int[n];
        
        helper[0] = 1;
        for(int i = 1;i<n;i++)
            helper[i] = ratings[i] > ratings[i-1] ? helper[i - 1] + 1 : 1;
        
        for(int i = n - 2;i >= 0;i--)
            helper[i] = ratings[i] > ratings[i + 1] ? 
                        Math.max(helper[i],helper[i + 1] + 1) : helper[i];

        int result = 0;
        
        for(var val : helper)
            result += val;
        
        return result;
    }
}