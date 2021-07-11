class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
         if(arr.length < k) return 0;
        int count = 0;

        int sum = 0;
        for(int i = 0;i<k;i++)
            sum+=arr[i];
        if(sum/k >= threshold) count++;
        int tempsum = sum;
        for(int i = k;i<arr.length;i++){
            tempsum+=arr[i] - arr[i-k];
            if(tempsum/k >= threshold)
                count++;
        }
        return count;
    }
}