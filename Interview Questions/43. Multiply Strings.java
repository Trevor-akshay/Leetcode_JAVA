class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
          
        int n = num1.length();
        int m = num2.length();
        int[] temp = new int[n + m - 1];
        
        for(int i = n - 1;i>=0;i--){
            for(int j = m - 1;j>=0;j--){
                int x = num1.charAt(i) - '0';
                int y = num2.charAt(j) - '0';
                temp[i + j] += x * y;
            }
        }
        
        for(int i = temp.length-1;i>0;i--){
            temp[i - 1] += temp[i] / 10;
            temp[i] = temp[i] % 10;
        }
        
        StringBuilder s = new StringBuilder();
        for(int i = 0;i<temp.length;i++){
            s.append(temp[i]);
        }
        
        return s.toString();
    }
}