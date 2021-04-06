class Solution {
    public int getKth(int lo, int hi, int k) {
      Map<Integer,Integer> map = new LinkedHashMap<>();
      for(int i = lo;i<=hi;i++){
         int n = i;
         int count = 0;
         while(n!=1){
            if(n % 2 == 0)
               n/=2;
            else
               n = n * 3 + 1;
            count++;
         }
         map.put(i,count);
      }
      Map<Integer,Integer> sorted = new LinkedHashMap<>();
      map.entrySet().stream().
              sorted(Map.Entry.comparingByValue()).
              forEach(v -> sorted.put(v.getKey(),v.getValue()));

      for(var item : sorted.keySet()){
         if(k == 1)
            return item;
         k--;
      }
      throw null;
    }
}