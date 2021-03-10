class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] numbers = new int[n];
        for(int i = 0;i<n;i++)
            numbers[i] = i+1;
        List<List<Integer>> list = new ArrayList<>();
        combineHelper(list,new ArrayList<>(),numbers,k,0);

        return  list;
    }

    private void combineHelper(List<List<Integer>> lists,List<Integer> list,
                                      int[] numbers,int k,int pos){
        if(k == 0){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i = pos;i<numbers.length;i++){
            list.add(numbers[i]);
            combineHelper(lists,list,numbers,k-1,i+1);
            list.remove(list.size()-1);
        }
    }
}