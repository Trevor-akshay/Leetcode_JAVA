class Solution {
    public int getWinner(int[] arr, int k) {
       int left=0,right=1,init=k;
    while(right<arr.length){//2,1,3,5,4,6,7
        if(arr[left]>arr[right]){
            right++;
            k--;
        }else{
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            k=init;
        }
        
        if(k==0)
            return arr[left];
    }
    return arr[left];
    }
}