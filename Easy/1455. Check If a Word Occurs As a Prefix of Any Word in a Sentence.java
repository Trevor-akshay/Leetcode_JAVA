class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int index = 1;
        for(String word : sentence.split(" ")){
            if(word.startsWith(searchWord))
                return index;
            index++;
            
        }
        
        return -1;
    }
}