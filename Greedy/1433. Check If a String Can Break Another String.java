class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);
        
        boolean found = true;
        for(int i = 0;i<c1.length && found;i++){
            found = c1[i] >= c2[i];
        }
        if(found)
            return true;
        found = true;
        for(int i = 0;i<c2.length && found;i++){
            found = c2[i] >= c1[i];
        }

        return found;
    }
}