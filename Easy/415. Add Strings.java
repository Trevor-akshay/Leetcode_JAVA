class Solution {
    public String addStrings(String num1, String num2) {
        if(num1.equals("0") && num2.equals("0"))
            return "0";
       int n = Math.max(num1.length(),num2.length());
        int[] arr = new int[n+1];
        int carry = 0;
        int index = n;
        for(int i = num1.length()-1,j=num2.length()-13
            ;i>=0 || j>=0|| carry == 1 ;i--,j--){
            
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            arr[index--] = (x + y + carry) % 10;
            carry = (x+y+carry)/10;
        }

        StringBuilder S = new StringBuilder();
        for(int i = 0;i<arr.length;i++){
            if(S.length() == 0 && arr[i] == 0)
                continue;
            S.append(arr[i]);
        }
        return S.toString();
    }
}