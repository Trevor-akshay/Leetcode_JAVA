class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int median = arr[((n - 1) / 2)];

        int[] result = new int[k];
        int index = 0;
        int low = 0, high = n - 1;

        while (index < k) {
            int value1 = Math.abs(arr[low] - median);
            int value2 = Math.abs(arr[high] - median);

            if (value1 > value2)
                result[index++] = arr[low++];
            else
                result[index++] = arr[high--];
        }

        return result;

    }
}