class Solution {
    public int numMagicSquaresInside(int[][] g) {
         int m=g.length,n=g[0].length,count=0;
        for (int i=0;i<=m-3;i++){
            for (int j=0;j<=n-3;j++){
                if (get(g,i,j)) count++;
            }
        }
        return count;
    }
    public boolean get(int[][] g, int i,int j){
        if (g[i+1][j+1]!=5) return false;
        int[] v=new int[16];
        for (int x=i;x<=i+2;x++){
            for (int y=j;y<=j+2;y++){
                v[g[x][y]]++;
            }
        }
        for (int x=1;x<=9;x++) 
            if (v[x]!=1) return false;
            if (g[i][j]+g[i][j+1]+g[i][j+2]!=15) return false;
            if (g[i][j]+g[i+1][j]+g[i+2][j]!=15) return false;
            if (g[i][j]+g[i+1][j+1]+g[i+2][j+2]!=15) return false;
            if (g[i+2][j]+g[i+2][j+1]+g[i+2][j+2]!=15) return false;
            if (g[i][j+2]+g[i+1][j+2]+g[i+2][j+2]!=15) return false;                 
			if (g[i][j+2]+g[i+1][j+1]+g[i+2][j]!=15) return false;
        return true;
    }
}