class Solution {
    public int beautySum(String str) {
    int result = 0;

      for(int i = 0;i<str.length();i++){
         int[] buckets = new int[26];
         for(int j = i;j<str.length();j++){
            buckets[str.charAt(j) -'a']++;
            result += stringBeautify(buckets);
         }
      }

      return result;
   }

   private int stringBeautify(int[] bucket){
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;

      for(int item : bucket){
         if(item == 0)
            continue;
         min = Math.min(min,item);
         max = Math.max(max,item);
      }
      return max - min;
}
}