class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length-1;
        if(arr[low] >= 0)
            return isValid(arr,low,high,false);
        else if(arr[high] < 0)
            return isValid(arr,low,high,true);
        
        int index = binarySearchIndex(arr);
        return isValid(arr,low,index,true) && isValid(arr,index+1, high,false);
        
    }
    
    private int binarySearchIndex(int[] arr){
        int low = 0;
        int high = arr.length-1;
        int index = 0;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(arr[mid] < 0){
                low = mid + 1;
                index = mid;
            }
            else
                high = mid - 1;
        }
        return index;
    }
    
    private boolean isValid(int[] arr,int low,int high,boolean isNegative){
        Map<Integer,Integer> map = new HashMap<>();
        int pairs = 0;
        if(isNegative){
            for(int i = low;i<=high;i++){
                int diff = arr[i] * 2;
                if(map.containsKey(diff)){
                    pairs++;
                    if(map.get(diff) == 1)
                        map.remove(diff);
                    else
                        map.put(diff,map.get(diff) - 1);
                }else
                    map.merge(arr[i],1,Integer::sum);
            }
        }else{
            for(int i = high;i>=low;i--){
                int power = arr[i] * 2;
                if(map.containsKey(power)){
                    pairs++;
                    if(map.get(power) == 1)
                        map.remove(power);
                    else
                        map.put(power,map.get(power) - 1);
                }else
                    map.merge(arr[i],1,Integer::sum);
            }
        }
        return map.isEmpty();
    }
   
}