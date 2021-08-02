class Solution {
    public long numberOfWeeks(int[] milestones) {
        long max = 0;
        long score = 0 ;
        for(var  m : milestones){
            max = Math.max(max,m);
            score += m;
        }
        
        return score - max >= max ? score : (score - max) * 2 + 1;
    }
}