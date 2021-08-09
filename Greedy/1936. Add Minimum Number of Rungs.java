class Solution {
    public int addRungs(int[] rungs, int dist) {
      int count = 0;
      int place = 0;
      for(var rung : rungs){
          count += (rung - place - 1) / dist;
          place = rung; 
      }
      return count;
    }
}