class Solution {
    public int numMatchingSubseq(String S, String[] words) {
     Map<Character, TreeSet<Integer>> map = new HashMap<>();
        for(int i = 0; i< S.length() ;i++){
            char c = S.charAt(i);
            map.put(c, map.getOrDefault(c, new TreeSet()));
            map.get(c).add(i);
        }
        int count = 0;
        for(String word : words){
            Integer index = -1;
            int j = 0;
            for(; j<word.length() ;j++){
                if(!map.containsKey(word.charAt(j))){
                    break;
                }
                index = map.get(word.charAt(j)).ceiling(index);
                if(index == null) break;
                index++;
            }
            if(j == word.length()) count++;
        }
        return count;
		}
}