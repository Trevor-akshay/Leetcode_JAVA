class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
   int temp = 0;
   for (int j : gain) {
      temp += j;
      max = Math.max(max, temp);
   }
        return max;
    }
}