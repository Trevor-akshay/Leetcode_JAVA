class Solution {
    public int countVowelStrings(int n) {
        char[] vowels = {'a','e','i','o','u'};
        Set<String> set = new HashSet<>();

        countVowelsStringsHelper(n,set,new StringBuilder(),vowels,0);

        return set.size();
    }

    private void countVowelsStringsHelper(int n,Set<String> set,
                                                 StringBuilder str,char[] vowels,int start){
    if(str.length() > n)
            return;
    if(str.length() == n){
        set.add(str.toString());//aeiou
        return;
    }
        for(int i=start;i<vowels.length;i++){
        str.append(vowels[i]);
        countVowelsStringsHelper(n,set,str,vowels,i);
        str.deleteCharAt(str.length()-1);
    } 
    }
}