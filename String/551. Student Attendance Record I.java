class Solution {
    public boolean checkRecord(String s) {
        int absent = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == 'A')
                absent++;
            else if(s.charAt(i) == 'L'){
                int late = 0;
                while(i<s.length() && 
                     s.charAt(i) == 'L'){
                    late++;
                    i++;
                }
                
                if(late >= 3)
                    return false;
                else if(i<s.length() && s.charAt(i) == 'A')
                    absent++;

            }
            if(absent >= 2)
                return false;
        }
        return true;
    }
}