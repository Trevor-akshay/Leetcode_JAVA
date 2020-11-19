class Solution {
     public int longestOnes(int[] A, int K) {
          if(Arrays.stream(A).sum() == 0 & K == 0) return 0;
       int max = 0;
        int left = 0,right = 0;
        int count  = 0; //1,1,1,0,0,0,1,1,1,1,0
        while(right<A.length){
            if(A[right] == 0)
                count++;
            while (count > K && left < right){
                if(A[left++] == 0)
                    count--;
            }
            max = Math.max(right-left+1,max);
            right++;
        }
        return max;
    }
}