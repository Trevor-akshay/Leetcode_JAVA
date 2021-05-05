class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
       List<String> list = new ArrayList<>();
        for(int i = 0;i< words.length;i++){
            String word = words[i];
            Map<Character,Character> map = new HashMap<>();
            Map<Character,Character> map1 = new HashMap<>();
            boolean flag = true;
            for(int j = 0;j<word.length();j++){
                char patternChar = pattern.charAt(j);
                char wordChar = word.charAt(j);
                if(map.containsKey(wordChar)){
                    if(map.get(wordChar) != patternChar){
                        flag = false;
                        break;
                    }
                }else{
                    map.put(wordChar,patternChar);
                }
                if(map1.containsKey(patternChar)){
                    if(map1.get(patternChar) != wordChar){
                        flag = false;
                        break;
                    }
                }else{
                    map1.put(patternChar,wordChar);
                }
            }
            if(flag)
                list.add(word);
        }
        return list;
    }
}