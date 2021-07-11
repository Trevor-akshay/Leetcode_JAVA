class Solution {
    public int countTriples(int n) {
        int count = 0;
        for(int i = 1;i<=n-1;i++){
            for(int j = i+1;j<=n-1;j++){
                int x = (int)Math.pow(i,2);
                int y = (int)Math.pow(j,2);
                int z = (int)Math.sqrt(x + y);
                if((int)Math.pow(z,2) == ( x + y) && z<=n){
                    count+=2;
                }
            }
        }
        return count;
    }
}