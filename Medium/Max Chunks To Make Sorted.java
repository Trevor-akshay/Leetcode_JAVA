class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0, maxCurrent = 0;
        for (int i = 0; i < arr.length; i++) {
            maxCurrent = Math.max(maxCurrent, arr[i]);
            if (maxCurrent == i)
                chunks++;
        }
        return chunks;
    }
}