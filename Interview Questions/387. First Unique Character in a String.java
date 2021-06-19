class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> frequency = new HashMap<>();
        for(char c : s.toCharArray())
            frequency.put(c,frequency.getOrDefault(c,0)+1);
        for(int i = 0;i<s.length();i++)
            if(frequency.get(s.charAt(i)) == 1)
                return i;
        return -1;
    }
}