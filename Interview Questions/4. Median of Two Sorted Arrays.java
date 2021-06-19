class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length + nums2.length];
        merge(array,nums1,nums2);
        
        if(array.length % 2 == 1 || array.length == 1)
            return array[array.length >> 1];
        double value = (array[array.length >> 1] + array[(array.length >> 1) - 1] ) / 2.0;
        return value;
        
    }
    
    private void merge(int[] arr,int[] a,int[] b){
        int i = 0,j=0,k=0;
        while(i < a.length && j < b.length){
            if(a[i] < b[j])
                arr[k++] = a[i++];
            else
                arr[k++] = b[j++];
        }
        
        while(i < a.length)
            arr[k++] = a[i++];
        
        while(j < b.length)
            arr[k++] = b[j++];
    }
}