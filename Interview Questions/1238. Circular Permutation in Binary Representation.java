class Solution {
    public List<Integer> circularPermutation(int n, int start) {
    List<Integer> l1 =new ArrayList<Integer>();
    for(int i=0;i<(1<<n);i++)
    {
        l1.add(start^(i^(i>>1)));
    }
    return l1;
    }
}