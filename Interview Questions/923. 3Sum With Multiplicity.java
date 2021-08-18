class Solution {
    public int threeSumMulti(int[] A, int target) {
        Arrays.sort(A);
        long res = 0;
        for (int i = 0; i < A.length - 2; ++i) {
            int j = i + 1;
            int k = A.length - 1;
            while (j < k) {
                if (A[j] + A[k] < target - A[i]) { 
                    ++j;
                }else if (A[j] + A[k] > target - A[i]) {
                    --k;
                }else {
                    int l = 1, r = 1;
                    while (j + l < k && A[j + l] == A[j]) { 
                        ++l; 
                    } // l: number of elements equal to A[j].
                    while (j + l <= k - r && A[k - r] == A[k]) { 
                        ++r; 
                    }  
                    
                    res += A[j] == A[k] ? (k - j + 1) * (k - j) / 2 : l * r ;
                    j += l; // forward j by l steps.
                    k -= r; // backward k by r steps.
                }
            }
        }
        return (int)(res % 1_000_000_007);
    }
}