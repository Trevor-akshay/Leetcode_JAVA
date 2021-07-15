class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder s = new StringBuilder();
        while(a > 0 || b > 0){
            int n = s.length();
            if(n >= 2 && s.charAt(n-1) == 'a' && s.charAt(n-2) == 'a'){
                s.append('b');
                b--;
            }else if(n >= 2 && s.charAt(n-1) == 'b' && s.charAt(n-2) == 'b'){
                s.append('a');
                a--;
            }else if(a >= b){
                s.append('a');
                a--;
            }else{
                s.append('b');
                b--;
            }
        }
        return s.toString();
    }
}