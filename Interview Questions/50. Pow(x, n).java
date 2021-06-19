class Solution {
    public double myPow(double x, int n) {
         double res = 1.0;
        while(n!=0){
            if(Math.abs(n)%2 == 0){
                x*=x;
                n/=2;
            }
            if(n>0){
                res *= x;
                n--;
            }
            else{
                res*=(1/x);
                n++;
            }
        }
        return res;
    }
}