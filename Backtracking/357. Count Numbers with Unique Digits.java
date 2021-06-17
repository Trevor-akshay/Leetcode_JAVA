class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0)
            return 1;
        if(n == 1)
            return 10;
       int index=0;
        int result=0;
        int countDown=9;
        int countResult=1;
        while(true){
            if(index == 0){
                result=1;
                index++;
            }
            else if(index == 1){
                countResult *= countDown;
                result += countResult;
                index++;
            }
            else if(index == n){
                countResult *= countDown;
                result += countResult;
                break;
            }
            else{
                countResult *= countDown;
                result += countResult;
                index++;
                countDown--;
            }
        }
        return result;
    }
}