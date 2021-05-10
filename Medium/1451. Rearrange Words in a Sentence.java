class Solution {
    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        Arrays.sort(words,Comparator.comparing(String::length));

        StringBuilder S = new StringBuilder();
        for(var word : words){
            if(S.length() == 0){
                char c = word.charAt(0);
                if(c >= 'A' && c <= 'Z')
                    S.append(word).append(" ");
                else{
                    c =(char) (c - 'a' + 'A');
                    S.append(c).append(word.substring(1)).append(" ");
                }
                continue;
            }else if(word.charAt(0) >= 'A' && word.charAt(0) <= 'Z'){
                char c = word.charAt(0);
                c = (char) (c - 'A' + 'a');
                S.append(c).append(word.substring(1)).append(" ");
                continue;
            }
            S.append(word).append(" ");
        }
        return S.deleteCharAt(S.length()-1).toString();
    }
}