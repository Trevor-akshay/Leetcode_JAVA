class Solution {
    public int[][] generateMatrix(int n) {
        int [][] res=new int [n][n];
        int top=0;
        int bottom=n-1;
        int left=0;
        int right=n-1;
        
        int count=0;

        int size=n*n;
        while(count<size){
            for(int i=left;i<=right && count<size;i++){
                res[top][i]=++count;
            }
            top++;
            
            for(int i=top;i<=bottom && count<size;i++){
                res[i][right]=++count;
            }
            right--;
            
            for(int i=right;i>=left && count<size;i--){
                res[bottom][i]=++count;
            }
            bottom--;
            for(int i=bottom;i>=top && count<size;i--){
                res[i][left]=++count;
            }
            left++;
        }
        
        
       return res; 
    }
    
}