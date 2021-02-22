class Solution {
    public boolean halvesAreAlike(String s) {
       s = s.toLowerCase();
        
        int temp1 = 0,temp2 =0;
        for(int i=s.length()/2;i<s.length();i++){
            int j = i-s.length()/2;
            if(s.charAt(j) == 'a' ||s.charAt(j) == 'e' ||s.charAt(j) == 'i' ||s.charAt(j) == 'o' 
                    ||s.charAt(j) == 'u')
                    temp1++;
            if(s.charAt(i) == 'a' ||s.charAt(i) == 'e' ||s.charAt(i) == 'i' 
                    ||s.charAt(i) == 'o'
                    ||s.charAt(i) == 'u')
                        temp2++;
                }
        return temp1 == temp2;
    }
}