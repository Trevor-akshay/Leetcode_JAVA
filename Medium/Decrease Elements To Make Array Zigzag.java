class Solution {
    public int movesToMakeZigzag(int[] arr) {
       int[] temp = Arrays.copyOf(arr, arr.length);
    
  int ans1 = 0;
    for(int i=0;i<arr.length-1;i++){
        if(i%2==0){
            if(arr[i+1]>=arr[i]){
                ans1 += arr[i+1] - arr[i] + 1;
                arr[i+1] = arr[i]-1;
            }
        }else{
            if(arr[i+1]<=arr[i]){
                ans1 += arr[i] - arr[i+1] + 1;
                arr[i] = arr[i+1]-1;
            }
        }
    }
        
    int ans2 = 0;
    arr = temp;
    
    
    for(int i=0;i<arr.length-1;i++){
        if(i%2!=0){
            if(arr[i+1]>=arr[i]){
                ans2 += arr[i+1] - arr[i] + 1;
                arr[i+1] = arr[i]-1;
            }
        }else{
            if(arr[i+1]<=arr[i]){
                ans2 += arr[i] - arr[i+1] + 1;
                arr[i] = arr[i+1]-1;
            }
        }
    }
        
    return Math.min(ans1, ans2);
    }
}