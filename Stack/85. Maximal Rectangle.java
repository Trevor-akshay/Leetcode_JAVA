class Solution {
    public int maximalRectangle(char[][] grid) {
        if(grid.length==0)return 0;

        int prerow[][]=new int[grid.length][grid[0].length];

        int res=0;

        

        for(int i=0;i<grid.length;i++){

            int sum=0;

            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j]=='1'){

                    sum++;

                    prerow[i][j]=sum;

                }else{

                    sum=0;

                    prerow[i][j]=0;

                }

            }

        }

        

        for(int i=0;i<grid.length;i++){

            for(int j=0;j<grid[0].length;j++){

                

                int r=i;

                int h=0;

                int min=Integer.MAX_VALUE;

                while(r>=0&&grid[r][j]!='0'){

                    h++;

                    min=Math.min(min,prerow[r][j]);

                    r--;

                    res=Math.max(res,h*min);

                } 

            }

        }

        return res;
    }
}