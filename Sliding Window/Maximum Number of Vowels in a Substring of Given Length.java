class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a','e','i','o','u');
        int right = 0,left = 0;
        int maxVowels = 0;
        for(;right<k;right++){
            if(vowels.contains(s.charAt(right)))
                maxVowels++;
        }
        int currVowels = maxVowels;
        for(;right<s.length();right++){
            if(vowels.contains(s.charAt(left++))) currVowels--;
            if(vowels.contains(s.charAt(right))) currVowels++;
            maxVowels = Math.max(maxVowels,currVowels);
        }
        return maxVowels;
    }
}