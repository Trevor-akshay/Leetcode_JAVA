class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder s = new StringBuilder();
        int A = 0,B=0,C=0;
        int n = a + b + c;
        
        for(int i = 0;i<n;i++){
            if((a >= b && a >= c && A != 2) || (C == 2 && a > 0) || (B == 2 && a > 0)){
                s.append('a');
                a--;
                A++;
                B=0;
                C=0;
            }else if((b >= a && b >= c && B != 2) || (A == 2 && b > 0) || (C == 2 && b > 0)){
                s.append('b');
                b--;
                B++;
                A=0;
                C=0;
            }else if((c >= b && c >= a && C != 2) || (A == 2 && c > 0) || (B == 2 && c > 0)){
                s.append('c');
                c--;
                C++;
                A = 0;
                B = 0;
            }else
                break;
        }
        return s.toString();
    }
}