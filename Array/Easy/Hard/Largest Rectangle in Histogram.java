class Solution {
    public int largestRectangleArea(int[] arr) {
       Deque<Integer> stack = new ArrayDeque<>();
    int n = arr.length, max = 0, curr, height, width;
    for (int i = 0; i <= n; ++i) {
        curr = i == n ? 0 : arr[i];
        while (!stack.isEmpty() && arr[stack.peek()] >= curr) 
            max = Math.max(max, arr[stack.pop()] * (stack.isEmpty() ? i : i - stack.peek() - 1));
        stack.push(i);
    }
    return max;
}}