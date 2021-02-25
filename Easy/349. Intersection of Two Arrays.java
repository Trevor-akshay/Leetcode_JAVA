class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int item : nums1)
                set.add(item);
        
        Set<Integer> set1 = new HashSet<>();
        for(int item : nums2)
            if(set.contains(item))
                set1.add(item);
        
        int[] result = new int[set1.size()];
        int i = 0;
        for(int item : set1)
            result[i++] = item;
        
        return result;
    }
}