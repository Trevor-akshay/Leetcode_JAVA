class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        List<Integer> secondRow = new ArrayList<>();
        int idx = 0;
        
        while(idx < colsum.length && (upper >= 0 || lower >= 0)){    
            if(colsum[idx] == 0){
                firstRow.add(0);
                secondRow.add(0);   
            }
            else if(colsum[idx] == 2){
                if(upper < 1 || lower < 1)
                    return result;
                firstRow.add(1);
                secondRow.add(1);
                upper--;lower--;
            }else if(upper > lower){
                if(upper < 1)
                    return result;
                firstRow.add(1);
                secondRow.add(0);
                upper--;
            }else{
                if(lower < 1)
                    return result;
                firstRow.add(0);
                secondRow.add(1);
                lower--;
            }
            idx++;
        }
        
        if(idx < colsum.length || upper > 0 || lower > 0)
            return result;
        
        result.add(firstRow);result.add(secondRow);
        return result;
    }
}