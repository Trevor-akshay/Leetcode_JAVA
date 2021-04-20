class Solution {
    public int nthUglyNumber(int n) {
       TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        for(int i = 1;i<n;i++){
            var val = set.pollFirst();
            set.add(val * 2);
            set.add(val * 3);
            set.add(val * 5);
        }
       // System.out.println(set);
        return set.pollFirst().intValue();
    }
}