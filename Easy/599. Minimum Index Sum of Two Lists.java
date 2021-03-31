class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
     Map<String,Integer> map = new HashMap<>();
         for(int i = 0;i<list1.length;i++)
            map.put(list1[i],i);

         Map<String,Integer> map2 = new HashMap<>();
         for(int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i]))
               map2.put(list2[i],i);
         }
         List<String> list = new ArrayList<>();
         int index = -1;
         for(var item : map2.keySet()){
            if(index == -1){
               list.add(item);
               index  = map.get(item) + map2.get(item);
            }
            else if(map2.get(item) + map.get(item) == index){
               list.add(item);
            }
            else if(map2.get(item) + map.get(item) < index){
               list.clear();
               list.add(item);
               index = map.get(item) + map2.get(item);

            }
         }
        String[] res = new String[list.size()];
        for(int i =0;i<list.size();i++)
            res[i] = list.get(i);
         return res;
    }
}