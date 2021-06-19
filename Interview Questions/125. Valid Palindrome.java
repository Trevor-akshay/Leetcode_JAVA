class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        s=s.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        for(char c:s.toCharArray())
            if((c >= 'a' && c <= 'z') ||( c >= '0' && c <= '9'))
                stringBuilder.append(c);
        for(int i = 0,j=stringBuilder.length()-1;i<j;i++,j--){
            if(stringBuilder.charAt(i)!=stringBuilder.charAt(j))
                return false;
        }
        return true;
    }
}