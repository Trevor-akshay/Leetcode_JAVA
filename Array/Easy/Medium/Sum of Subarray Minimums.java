class Solution {
    public int sumSubarrayMins(int[] A) {
         long value = 0;
        for(int item : A)
            value+= item;
        for(int i = 0;i<A.length;i++){
            int min = A[i];
            for(int j = i+1;j<A.length;j++){
                if(A[j]<min){
                    value+=A[j];
                    min = A[j];
                }
                else{
                    value+=min;
                }
            }
        }
        
        return (int)(value%(Math.pow(10,9)+7));
    }
}