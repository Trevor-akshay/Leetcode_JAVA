class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
      List<int[]> list = new ArrayList<>();
        for(int[] restaurant : restaurants){
            if(veganFriendly == 1){
                if(restaurant[2] == 1 && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance){
                    list.add(restaurant);
                }
            }else{
                if(restaurant[3] <= maxPrice && restaurant[4] <= maxDistance){
                    list.add(restaurant);
                }
            }

        }
        list.sort((a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            } else {
                return b[1] - a[1];
            }
        });
        List<Integer> indexes = new ArrayList<>();
        for(int[] i : list){
            indexes.add(i[0]);
        }
        return indexes;
    }
}