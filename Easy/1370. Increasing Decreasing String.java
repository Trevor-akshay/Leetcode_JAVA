class Solution {
    public String sortString(String s) {
      int[] freq = new int[26];
      for(char c : s.toCharArray())
         freq[c - 'a']++;

      StringBuilder S = new StringBuilder();
      boolean flag = false;
      boolean verify = true;
      while(verify){
          verify = false;
         if(flag){
            for(int i = freq.length-1;i>=0;i--){
               if(freq[i] > 0){
                  char c = (char) (i + 97);
                  S.append(c);
                  freq[i]--;
                  verify = true; 
               }
            }
            flag = false;
         }else {
            for (int i = 0; i < freq.length; i++) {
               if (freq[i] > 0) {
                  char c = (char) (i + 97);
                  S.append(c);
                  freq[i]--;
                   verify = true;
               }
            }
            flag = true;
         }
         }
      return S.toString();
    }
}