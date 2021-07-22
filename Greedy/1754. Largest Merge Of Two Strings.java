class Solution {
    public String largestMerge(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        char[] chars = new char[n + m];
        int idx = 0;
        int i = 0,j = 0;

        while(i < n && j < m){
            if(word1.charAt(i) == word2.charAt(j)){
                int k = i,l=j;
                while (k < n  && l < m){
                    if(word1.charAt(k) != word2.charAt(l))
                        break;
                    k++;
                    l++;
                }
                if(k == n && l == m)
                    chars[idx] = word1.charAt(i++);
                else if(k < n && l == m)
                    chars[idx] = word1.charAt(i++);
                else if(k == n && l < m)
                    chars[idx] = word2.charAt(j++);
                else if(word1.charAt(k) > word2.charAt(l))
                    chars[idx] = word1.charAt(i++);
                else
                    chars[idx] = word2.charAt(j++);
            }
            else if(word1.charAt(i) > word2.charAt(j))
                chars[idx] = word1.charAt(i++);
            else
                chars[idx] = word2.charAt(j++);
            idx++;
        }

        while (i < n)
            chars[idx++] = word1.charAt(i++);

        while (j < m)
            chars[idx++] = word2.charAt(j++);

        return new String(chars);
    }
}