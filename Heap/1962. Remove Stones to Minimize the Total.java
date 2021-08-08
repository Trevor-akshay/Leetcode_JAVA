class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b - a);
        int total = 0;

        for(var pile : piles){
            q.offer(pile);
            total += pile;
        }
        
        while(k-- > 0 && q.peek() != 1){
            var poll = q.poll();
            total -= poll;
            poll = poll % 2 == 0 ? poll / 2 : poll / 2 + 1;
            total += poll;
            q.offer(poll);
        }
           
        return total;
    }
}