class Solution {
    public int getSum(int a, int b) {
            int[] arr = new int[2];
            arr[0] = a;
             arr[1] = b;
            return Arrays.stream(arr).sum();
    }
}