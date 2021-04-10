class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 11)
            return new ArrayList<>();
      int right=0;
      Set<String> set  =new HashSet<>();
      StringBuilder S = new StringBuilder();
      while(right < 10){
         S.append(s.charAt(right++));
      }
      set.add(S.toString());
      Set<String> list = new HashSet<>();
      while (right < s.length()){
         S.deleteCharAt(0);
         S.append(s.charAt(right));
         if(set.contains(S.toString()))
            list.add(S.toString());
         else
            set.add(S.toString());
         right++;
      }
      return new ArrayList<>(list);
    }
}