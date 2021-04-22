class Solution {
    public int binaryGap(int n) {
       String binary = Integer.toBinaryString(n);// 1 0 1 1 0
       int right = 0,length = 0;
       int left = 0;
       while(right < binary.length()){
           if(binary.charAt(left) != '1' && binary.charAt(right) == '1')
               left = right;
           else if(binary.charAt(left) == '1' && binary.charAt(right) == '1'){
               length = Math.max(length,right-left);
               left = right;
           }

           right++;
       }
       return length;
    }
}