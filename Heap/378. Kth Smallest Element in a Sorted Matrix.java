class Solution {
    public int kthSmallest(int[][] matrix, int k) {
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = matrix.length * matrix[0].length;
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                if(minHeap.size() < n - k + 1){
                    minHeap.offer(matrix[i][j]);
                }
                else if(minHeap.peek() < matrix[i][j]){
                    minHeap.poll();
                    minHeap.offer(matrix[i][j]);
                }
            }
        }
        return minHeap.peek();
    }
}