class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> q = new PriorityQueue<>(
                (a,b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]
        );
        //[0] = value && [1] = | x - value |
        for (var num:arr){
            int diff = Math.abs(num - x);
            q.offer(new int[]{num,diff});
            if(q.size() > k)
                q.poll();
            
        }
        
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty())
            result.add(q.poll()[0]);
        Collections.sort(result);
        
        return result;
    }
}