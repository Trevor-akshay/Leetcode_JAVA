class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for(int item : candyType){
            if(set.size() == candyType.length / 2) 
                break;
            set.add(item);
        }

        return set.size() < candyType.length / 2 ? set.size() : candyType.length / 2;
    }
}