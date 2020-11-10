class Solution {
    public int minIncrementForUnique(int[] A) {
         if(A.length <= 1) return  0;
        
        Arrays.sort(A);
        int moves = 0;
        for (int i = 1; i < A.length; i++) {

            if (A[i] <= A[i - 1]) {
               moves += A[i - 1] + 1 - A[i];
                A[i] = A[i - 1] + 1;
            }
        }
        return moves;
    }
}