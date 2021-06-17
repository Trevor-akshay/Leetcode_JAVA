class Solution {
    public int peakIndexInMountainArray(int[] arr) {
       int left = 0;
       int right = arr.length - 1;
       while(left <= right){
           int mid = (left + right)/2;
           
           if(arr[mid] > Math.max(arr[mid-1],arr[mid+1]))
               return mid;
           else if(arr[mid] > arr[mid - 1])
               left = mid;
           else
               right = mid;
               
       }

       return left;
    }
}
///     40,48,61,75,100,99,98,39,30,10
//      l            m               r