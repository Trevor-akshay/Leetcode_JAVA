class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int[] array = new int[matrix.length*matrix[0].length];
        int index =0;
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    array[index++] = anInt;
                }
            }
        Arrays.sort(array);
        return array[k-1];
    }
}