class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last =  new  int[26];
        int index = 0;
        for(char c : S.toCharArray())
            last[c-'a'] = index++;
        
        int left = 0,right = 0;
        int compare = 0;
        
        List<Integer> list = new ArrayList<>();
        while(right < S.length()){
            compare = Math.max(last[S.charAt(right)-'a'],compare);
            
            if(right == compare){
                list.add(right - left +1);
                left = right+1;
            }
            right++;
        }
        
        return list;
    }
}