class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
      int Satisfied = 0;
        int checkSatisfied = 0;
        int result = 0;
        for(int i = 0; i < customers.length; ++i) {
            if(grumpy[i] == 0) {
                Satisfied += customers[i];
            } else {
                checkSatisfied += customers[i];
            }

            if(i >= X) {
                checkSatisfied -= customers[i-X]*grumpy[i-X];
            }
            result = Math.max(checkSatisfied, result);
        }
        return Satisfied + result;
    }
}