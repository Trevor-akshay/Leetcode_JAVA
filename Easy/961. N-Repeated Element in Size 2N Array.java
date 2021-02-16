class Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for(int num : A) {
            if(set.contains(num)) return num;
            else set.add(num);
        }
        return -1;
    }
}