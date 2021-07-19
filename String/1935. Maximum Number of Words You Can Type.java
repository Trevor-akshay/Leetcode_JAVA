class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int[] freq = new int[26];
        for(char c : brokenLetters.toCharArray())
            freq[c-'a']++;
        
        int count = 0;
        Outer :for(var words : text.split("\\s")){
            for(var c : words.toCharArray()){
                if(freq[c-'a'] > 0)
                    continue Outer;
            }
            count++;
        }
        
        return count;
    }
}