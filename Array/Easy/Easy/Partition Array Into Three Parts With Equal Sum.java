class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum =Arrays.stream(A).sum();
        if(sum%3 != 0)
            return false;
        int temp = 0,sumDivided = sum/3,count = 0;

        for(int i = 0;i<A.length;i++){
            temp+=A[i];
            if(temp == sumDivided){
                count++;
                temp = 0;
            }
        }
        return count>=3?true:false;
    }
}