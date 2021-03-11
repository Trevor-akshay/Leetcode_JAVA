class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
          List<Integer> result = new ArrayList<>();
        numsSameConsecDiffHelper(result,new ArrayList<>(),n,k);
        int[] array = new int[result.size()];
        for(int i = 0;i<result.size();i++)
            array[i] = result.get(i);
        return array;
        }

    private void numsSameConsecDiffHelper(List<Integer> result,List<Integer> list,int n,int k){
        if(list.size() == n && list.get(0) != 0){
            result.add(realNumber(list));
             return;
        }
        if(list.size() > n)
            return;
        for(int i = 0;i<=9;i++){
            if(list.isEmpty() || isValidNumber(list,i,k)){
                list.add(i);
                numsSameConsecDiffHelper(result,list,n,k);
                list.remove(list.size()-1);
            }
        }
    }

     private boolean isValidNumber(List<Integer> list,int value,int k){
        return Math.abs(list.get(list.size()-1) - value) == k;
    }
     private int realNumber(List<Integer> list){
        int result = 0;
        for(int i =0;i<list.size();i++){
            result = (result*10) + list.get(i);
        }
        return result;
    } 
}
