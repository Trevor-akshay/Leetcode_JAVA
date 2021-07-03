class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for(int i = 1;i<=n/2;i++){
            if(num.charAt(0) == '0' && i > 1)
                break;
            for(int j = i+1;j<n;j++){
                int first = 0,second = i,third = j;
                if (num.charAt(second) == '0' && third > second+1) 
                    break;

                while(third < n){
                    String temp = num.substring(third);
                    Long sum = Long.parseLong(num.substring(first,second)) + 
                               Long.parseLong(num.substring(second,third));
                    if(temp.startsWith(sum.toString())){
                        first = second;
                        second = third;
                        third += sum.toString().length();
                    }
                    else
                        break;
                }
                
                if(third == n)
                    return true;
            }
        }
        
        return false;
    }
}