class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       Map<Integer,Integer> nums1Map = new HashMap<>();
        for(int item : nums1)
            nums1Map.put(item,nums1Map.getOrDefault(item,0)+1);
        Map<Integer,Integer> nums2Map = new HashMap<>();
        for(int item:nums2)
            nums2Map.put(item,nums2Map.getOrDefault(item,0)+1);
        int n = 0;
        int index = 1;
        List<Integer> list = new ArrayList<>();
        if(nums1.length > nums2.length){
            n=nums2.length;
            index = 2;
        }
        else{
            n=nums1.length;
        }
        if(index == 1){
        for(int i = 0;i<n;i++){
            if(nums2Map.containsKey(nums1[i])){
                list.add(nums1[i]);
                if(nums2Map.get(nums1[i]) == 1) nums2Map.remove(nums1[i]);
                else nums2Map.put(nums1[i],nums2Map.getOrDefault(nums1[i],0)-1);
            }
        }
        }else{
            for(int i = 0;i<n;i++){
                if(nums1Map.containsKey(nums2[i])) {
                    list.add(nums2[i]);
                    if (nums1Map.get(nums2[i]) == 1) nums1Map.remove(nums2[i]);
                    else nums1Map.put(nums2[i], nums1Map.getOrDefault(nums2[i],
                            0) - 1);
                }
            }
        }
        int[] result = new int[list.size()];
        for(int i =0;i<result.length;i++)
            result[i] = list.get(i);
        return result;
    }
}