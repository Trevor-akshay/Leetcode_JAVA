class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i = arr.length-1;i>=0;i--){
            int index = findMax(arr,i);
            if(index != -1){
                flip(arr,0,index);
                flip(arr,0,i);
                list.add(index+1);
                list.add(i+1);
            }
        }
        return list;
    }
    
    private int findMax(int[] arr,int index){
        int position = -1;
        int max = arr[index];
        for(int i = index-1;i>=0;i--){
            if(max < arr[i]){
                max = arr[i];
                position = i;
            }
        }
        
        return position;
    }
    
    private void flip(int[] arr,int left,int right){
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}