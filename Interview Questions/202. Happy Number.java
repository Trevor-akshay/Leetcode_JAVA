class Solution {
    public boolean isHappy(int n) {
        int p;
        while(n>1){
        p =n;
        n=0;
        while(p!=0){
            int pop = p%10;
            n+=pop*pop;
            p = p/10;
        }
        if(n==4) return false;
        }
    return n==1;
    }
}