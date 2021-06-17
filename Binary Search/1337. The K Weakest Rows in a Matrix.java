class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(
                (a,b)-> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]
        );
        for(int i = 0;i<mat.length;i++){
            int left = 0;
            int right = mat[i].length-1;
            int count = 0;
            while(left<=right){
                int mid = (left + right) / 2;
                if(mat[i][mid] == 1){
                    left = mid + 1;
                    count = left;
                }
                else{
                    right = mid - 1;
                }
            }
            q.offer(new int[]{count,i});
        }
        
        int[] result = new int[k];
        for(int i = 0;i<k;i++)
            result[i] = q.poll()[1];
        return result;
    }
}

