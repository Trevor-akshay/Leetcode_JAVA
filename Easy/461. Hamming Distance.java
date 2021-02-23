class Solution {
    public int hammingDistance(int x, int y) {
        int n = Math.max(Integer.toBinaryString(x).length(),
                Integer.toBinaryString(y).length());
        int[] xBinary = new int[n];
        int index = 0;
        while (x!=0){
            xBinary[index++] = x%2;
            x/=2;
        }
        int[] yBinary = new int[n];
        index = 0;
        while (y!=0){
            yBinary[index++] = y%2;
            y/=2;
        }

        int difference = 0;
        for(int i = 0;i<n;i++)
            if((xBinary[i] ^ yBinary[i]) != 0)
                difference++;

        return difference;
    }
}