class Solution {
    public int lenLongestFibSubseq(int[] A) {
     Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int longestSeq  = 0;
        for(int i=0; i< A.length; i++)
        {
            map.put(A[i],i);
        }
        
        for(int i=0; i< A.length-1; i++)
        {
            for(int j=i+1; j< A.length; j++)
            {
                int prev = A[i];
                int len = 0;
                int sum = prev+A[j];
                int k = j;
                while(map.containsKey(sum) && k < A.length) { 
                    if(len == 0)
                        len = 3;
                    else
                        len++;
                    if(len > longestSeq)
                        longestSeq = len;
                    prev = A[k];
                    k = map.get(sum);
                    sum = prev+A[k];
                }
            }
        }
        return longestSeq;
    }
}