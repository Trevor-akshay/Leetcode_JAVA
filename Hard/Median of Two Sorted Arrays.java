class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double value = 0;
        int[] result = new int[nums1.length + nums2.length];
        int i=0,j=0,k = 0;
        while(i<nums1.length)
            result[k++] = nums1[i++];
        while (j<nums2.length)
            result[k++] = nums2[j++];
       Arrays.sort(result);
        if(result.length%2==0){//1,2,3
            value = (result[result.length/2] + result[result.length/2 - 1]);
           
          return  value/2;
        }
        value = result[result.length/2];
        return value;
    }
}