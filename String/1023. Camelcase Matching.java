class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
      List<Boolean> list = new ArrayList<>();

      for (var q : queries) {
         int index = 0;
         boolean flag = true;
         for (var c : q.toCharArray()) {
            if(index < pattern.length() && c == pattern.charAt(index)){
               index++;
               continue;
            }
            if(c >= 'A' && c <= 'Z'){
               if(index >= pattern.length() || c != pattern.charAt(index)){
                  flag = false;
                  break;
               }
            }
         }
         flag = flag && index == pattern.length();
         list.add(flag);
      }
      return list;
    }
}