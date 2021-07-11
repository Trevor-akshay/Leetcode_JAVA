class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
          if(pieces == null || pieces.length == 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            
            map.put(arr[i], i);
        }
        int prev;
        for(int[] piece : pieces){
            prev = -1;
            for(int num : piece){
                if(!map.containsKey(num)) return false;
                if(prev != -1){
                    if(map.get(num) != prev + 1) return false; 
               }
                prev = map.get(num);
            }
        }
        return true;
    
    }
}