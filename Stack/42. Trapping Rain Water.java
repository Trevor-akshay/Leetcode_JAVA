class Solution {
    public int trap(int[] height) {
         int n = height.length;
        if (n == 0) return 0;
        int left = 0,right = n-1;
        int trappedWater = 0;
        int leftMax = height[left],rightMax = height[right];
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            System.out.println(trappedWater);
            if (leftMax < rightMax) {
                trappedWater += leftMax - height[left++];
            } else {
                trappedWater += rightMax - height[right--];
            }
        }
        return trappedWater;
    }
}