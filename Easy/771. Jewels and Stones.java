class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for(char c : jewels.toCharArray())
            set.add(c);
        int jewel = 0;
        for(char c : stones.toCharArray())
            jewel = set.contains(c) ? jewel+1 : jewel;
        
        return jewel;
    }
}