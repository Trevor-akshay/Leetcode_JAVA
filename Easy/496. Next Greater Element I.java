class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       Map<Integer,Integer> m2 = new HashMap();
        
        for(int i = 0; i < nums2.length; i++)
        {
            m2.put(nums2[i],i);
        }
        
        for(int i = 0; i < nums1.length; i++)
        {
            int key = m2.get(nums1[i]);
              if(key == nums2.length - 1)
              {
                nums1[i] = -1;
              }
                 for(int j = key + 1; j < nums2.length; j++)
                 {
                    int max = nums2[j];
                    if(max > nums2[key])
                    {
                      max = nums2[j];
                      nums1[i] = max;
                      break;
                   }
                   else{
                     nums1[i] = -1;
                 }
            }
        } 
        return nums1;
    }
}