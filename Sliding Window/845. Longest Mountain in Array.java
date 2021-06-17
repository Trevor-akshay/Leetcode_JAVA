class Solution {
    public int longestMountain(int[] arr) {
       if(arr.length < 3)
            return 0;
        int left = 0,right=1;
        int length = 0;
        int tempLength = 0;
        boolean midFound = false;
        while (right < arr.length) { // 2 1 4 7 3 2 5
            if (arr[right] <= arr[left]) {
                left = right;
                right++;
                continue;
            }
            if (arr[right] > arr[right - 1]) {
                while (right < arr.length && arr[right] > arr[right - 1]) {
                    while (right < arr.length - 1 && arr[right] > arr[right + 1]) {
                        right++;
                        midFound = true;
                    }
                    if (midFound) {
                        length = Math.max(length, right - left + 1);
                        left = right;
                        midFound = false;
                    }
                    right++;
                }
            } else {
                left = right;
                right++;
            }
        }

        return length;
    }
}