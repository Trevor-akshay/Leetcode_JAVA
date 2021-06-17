class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
       int max = 0;
        for(int i: difficulty) {             
            max = Math.max(max,i);
        }
        for(int i: worker) {
            max = Math.max(max,i);
        }
        int[] bucket = new int[max+1];
        for(int i=0;i<difficulty.length;i++) {                                                          
            bucket[difficulty[i]] = Math.max(profit[i],bucket[difficulty[i]]) ;
        }
        max = 0;
        for(int i=0;i<bucket.length;i++) {             
            bucket[i] = Math.max(max,bucket[i]);
            max = Math.max(max,bucket[i]);
        }
        int res = 0;
        for(int i: worker) {
            res+=bucket[i];
        }
        return res;
    }
}