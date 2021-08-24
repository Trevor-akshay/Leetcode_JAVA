class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int[] a = getValue(num1);
        int[] b = getValue(num2);
        
        int real = (a[0] * b[0]) - (a[1] * b[1]);
        int imag = (a[0] * b[1]) + (a[1] * b[0]);
        return real+"+"+imag+"i";
    }
    
    private int[] getValue(String num){
        String[] temp = num.split("\\+");
        return new int[]{Integer.parseInt(temp[0]),Integer.parseInt(temp[1].replace("i",""))};
    }
}