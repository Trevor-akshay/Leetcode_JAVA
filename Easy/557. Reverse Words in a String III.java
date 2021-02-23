class Solution {
    public String reverseWords(String s) {
         String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = 0;i<words.length;i++){
            StringBuilder stringBuilder = new StringBuilder();
            String wrd = words[i];
            for(int j=wrd.length()-1 ;j>=0;j--)
                stringBuilder.append(wrd.charAt(j));

            words[i] = stringBuilder.toString();
            result.append(words[i]).append(" ");
        }
        return result.deleteCharAt(result.length()-1).toString();
    }
}