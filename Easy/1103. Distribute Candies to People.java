class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
            int dist = 1;
            int index = 0;

            while(candies > 0 ){
                result[index % num_people] += Math.min(dist, candies);
                index++;
                candies = candies - dist;
                dist++;
            }
            return result;
    }
}