class Solution {
    public int minimumBuckets(String s) {
        Set<Integer> index = new HashSet<>();
        int i = 0;
        for(char c : s.toCharArray()){
            if(c == 'H')
                index.add(i);
            ++i;
        }
        if(index.size() == 0)
            return 0;
        if(s.length() == 1 && index.size() == 1)
            return -1;
        else if(s.length() == 1)
            return 0;
        if((s.charAt(0) == 'H' && s.charAt(1) == 'H') || 
            (s.charAt(s.length()-1) == 'H' && s.charAt(s.length()-2) == 'H'))
            return -1;
        
        int B = 0;
        for(i = 0;i<s.length();++i){
            if(i < s.length() - 2 && s.charAt(i) == 'H'){ 
                if(s.charAt(i + 1) == 'H' && s.charAt(i + 2) == 'H')
                    return - 1;
                else if(s.charAt(i + 2) == 'H' && index.contains(i)){
                    index.remove(i);index.remove(i + 2);
                    ++B;
                }
            }if(s.charAt(i) == 'H' && index.contains(i)){
                ++B;
                index.remove(i);
            }
        }
        return B;
    }
}