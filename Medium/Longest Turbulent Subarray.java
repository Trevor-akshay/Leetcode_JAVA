class Solution {
    public int maxTurbulenceSize(int[] arr) {
		int even = 1, odd = 1, res = 1;
        for(int i = 1; i < arr.length; i++){
            if((i % 2 == 0 && arr[i - 1] > arr[i]) || (i % 2 == 1 && arr[i - 1] < arr[i])){
                even++;
                odd = 1;
            } else if((i % 2 == 1 && arr[i - 1] > arr[i]) || (i % 2 == 0 && arr[i - 1] < arr[i])){
                odd++;
                even = 1;
            } else{
                odd = 1;
                even = 1;
            }
            //res = Math.max(res, odd);
            res = Math.max(res, Math.max(even,odd));
        }
        return res;
    }
}