class Solution {
    public int findTheWinner(int n, int k) {
       List<Integer> list = new ArrayList<>();
      for(int i =0;i<n;i++){
         list.add(i+1);
      }
      int index = k-1;
      while(list.size() != 1){
         list.remove(index);
         index =  (index + k -1) % list.size();
      }

      return list.get(0);
    }
}