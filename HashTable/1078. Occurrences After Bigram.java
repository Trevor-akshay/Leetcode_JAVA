class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> strings = new ArrayList<>();
        int index = 0;
        String[] words = text.split(" ");
        if(words.length < 3) return new String[]{};
        for(String word  : words){
            if(index < words.length -2 && word.equals(first) && words[index+1].equals(second))
                strings.add(words[index+2]);
            index++;
        }
        return strings.toArray(new String[]{});
    }
}