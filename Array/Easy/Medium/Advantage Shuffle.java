class Solution {
    public int[] advantageCount(int[] A, int[] B) {
         int[] result = new int[A.length];
        Arrays.sort(A);
        List<Integer> list = new ArrayList<>();
        for(int a : A){
            list.add(a);
        }
        for(int i= 0; i < B.length;i++){
            if(B[i] < list.get(0) || B[i] >= list.get(list.size() - 1)){
                result[i] = list.get(0);
                list.remove(0);
            }else{
                for(int e : list){
                    if(e > B[i]){
                        result[i] = e;
                        break;
                    }
                }
                list.remove(list.indexOf(result[i]));
            }
        }
        
        
        return result;
    }
}