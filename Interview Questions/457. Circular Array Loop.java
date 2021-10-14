class Solution {
    public boolean circularArrayLoop(int[] A) {
        for(int i = 0;i<A.length;i++){
            if(A[i] > 0 && loopSimulate(A,true,i))
                return true;
            if(A[i] < 0 && loopSimulate(A,false,i))
                return true;
        }   
        
        return false;
    }
    
    private boolean loopSimulate(int[] A,boolean positive,int start){
        int len = 1;
        int end = 0;
        end = (start + A[start]) % A.length;
        if(end < 0)
            end += A.length;
        Set<Integer> set = new HashSet<>();
        while(end != start){
            if(set.contains(end) || (positive && A[end] < 0) || (!positive && A[end] > 0))
                break;
            set.add(end);
            len++;
            end = (A[end] + end) % A.length;
            if(end < 0)
                end += A.length;
        }
        return end == start && len > 1;
    }
}