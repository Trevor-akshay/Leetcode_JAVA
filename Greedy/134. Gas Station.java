class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int n = cost.length;
        
        for(int i=0; i<n; ++i) {
            
            if(gas[i] >= cost[i]){
              int j = 0, k, sum = 0;
                  for(j=0 ; j < n ; ++j){
                      k = (i+ j) % n;
                     sum += gas[k] - cost[k];
                     if (sum < 0) {
                            if(k<i)
                               return -1;
                     else
                            i = k;
                    break;
                        }              
                }
            if(j==n) return i;
            }
        }
        return -1;
    }
}