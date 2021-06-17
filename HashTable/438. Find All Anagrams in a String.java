class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] pArray = new int[26];
        for(char c:p.toCharArray())
            pArray[c-'a']++;
        int[] sArray = new int[26];
        int left=0,right=0;
        while(right<p.length())
            sArray[s.charAt(right++)-'a']++;
        if(Arrays.equals(sArray,pArray))
            list.add(left);
        while (right<s.length()){
            sArray[s.charAt(left++)-'a']--;
            sArray[s.charAt(right++)-'a']++;
            if(Arrays.equals(sArray,pArray))
                list.add(left);
        }
        return list;
    }
}