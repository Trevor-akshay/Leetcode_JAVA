class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K)-atMostK(A, K-1);
    }

	private int atMostK(int[] A, int K) 
	{
       int left= 0, right=0, goodArrays=0;
        Map<Integer, Integer> map= new HashMap<>();
        while(right<A.length)
        {
            map.put(A[right],map.getOrDefault(A[right],0)+1);
            while(map.size() > K)
            {
                map.put(A[left],map.get(A[left])-1);
                if(map.get(A[left])==0) map.remove(A[left]);
                left++;
            }
            goodArrays += right-left+1;
            right++;
        }
        return goodArrays;
    }
}