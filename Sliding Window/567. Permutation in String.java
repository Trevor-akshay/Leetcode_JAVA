class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        Map<Character,Integer> s1Map = new HashMap<>();
        for(char s:s1.toCharArray())
            s1Map.put(s,s1Map.getOrDefault(s,0)+1);
        Map<Character,Integer> s2Map = new HashMap<>();
        int left = 0,right=0;
        for(;right<s1.length();right++){
            s2Map.put(s2.charAt(right),s2Map.getOrDefault(
                    s2.charAt(right),0)+1);
        }
        if(s2Map.equals(s1Map)) return true;
        for (;right<s2.length();right++){
            if(s2Map.get(s2.charAt(left)) == 1)
                s2Map.remove(s2.charAt(left++));
            else
                s2Map.put(s2.charAt(left),s2Map.getOrDefault(
                        s2.charAt(left++),0)-1);
            s2Map.put(s2.charAt(right),s2Map.getOrDefault(
                    s2.charAt(right),0)+1);
            if(s1Map.equals(s2Map))
                return true;
    }
        return false;
		}
}