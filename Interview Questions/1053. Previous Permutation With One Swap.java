class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int index = -1;
        
        for(int i = arr.length-1;i>0;i--){
            if(arr[i-1] > arr[i]){
                index = i-1;
                break;
            }
        }
        
        if(index == -1)
            return arr;
        
        for(int i = arr.length-1;i>index;i--){
            if(arr[i] < arr[index] && arr[i] != arr[i-1]){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break;
            }
        }
        
        return arr;
    }
}