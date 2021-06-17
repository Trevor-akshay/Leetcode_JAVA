class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer,Integer> map = new LinkedHashMap<>();
        for(int item : nums)
            map.merge(item,1,Integer::sum);
        PriorityQueue<Map.Entry<Integer,Integer>> q = new PriorityQueue<>(
                (a,b) -> b.getValue() - a.getValue()
        );
        for(var item : map.entrySet()){
            q.offer(item);
        }
        int[] res = new int[k];
        int index = 0;
        while (index!=k)
            res[index++] = q.poll().getKey();
        return res;
        }
    }
