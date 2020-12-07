class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        int non_wrap=kadane(arr);
        int sum=Arrays.stream(arr).sum();
        for(int i=0;i<arr.length;i++)
            arr[i]=-arr[i];
        int wrapped=kadane(arr);
        return wrapped+sum==0?non_wrap:Math.max(non_wrap,wrapped+sum);
        
    }
    public int kadane(int arr[])
    {
        int gSum=arr[0],curr_sum=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            curr_sum=Math.max(arr[i],arr[i]+curr_sum);
            
            if(curr_sum>gSum)
                gSum=curr_sum;
        }
        return gSum;
    }
}