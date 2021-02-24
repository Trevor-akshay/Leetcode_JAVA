class Solution {
    public int findComplement(int num) {
         StringBuilder stringBuilder = new StringBuilder(Integer.toBinaryString(num));
        for(int i = stringBuilder.length()-1;i>=0;i--){
            if(stringBuilder.charAt(i) == '1')
                stringBuilder.replace(i,i+1,"0");
            else
                stringBuilder.replace(i,i+1,"1");
        }
        int pow = 0;
        int result = 0;
        for(int i = stringBuilder.length()-1;i>=0;i--){
                if(stringBuilder.charAt(i) == '1')
                    result +=(int)Math.pow(2,pow);
                pow++;
            }
        return result;
    }
}