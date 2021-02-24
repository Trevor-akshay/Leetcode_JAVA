class Solution {
    public int[] shortestToChar(String s, char c) {
       int prev = -1;
        int next;
        int i = 0;
        while(i < s.length() && s.charAt(i) != c) i++;
        next = i;
        int[] result = new int[s.length()];
        for(i=0; i<s.length(); i++){
            int dist;
            if(prev == -1){
                dist = next-i;
            }
            else if(next == -1){
                dist = i-prev;
            }
            else{
                dist = Math.min((i-prev),(next-i));
            }
            result[i] = dist;
            if(dist == 0){
                prev = next;
                int j=i+1;
                while(j < s.length() && s.charAt(j) != c) j++;
                next = (j == s.length()) ? -1 : j;
            }
        }
        return result;
    }
}