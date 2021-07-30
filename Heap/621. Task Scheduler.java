class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : tasks)
            map.merge(c,1,Integer::sum);

        PriorityQueue<Map.Entry<Character,Integer>> q = new PriorityQueue<>(
                (a,b) -> b.getValue() - a.getValue()
        );
        q.addAll(map.entrySet());
        int time = 0;
        while (!q.isEmpty()){
            int k = n + 1;
            List<Map.Entry> temp = new ArrayList<>();
            while (k > 0 && !q.isEmpty()){
                var poll = q.poll();
                poll.setValue(poll.getValue()-1);
                time++;
                k--;
                if(poll.getValue() > 0)
                    temp.add(poll);
            }
            for(var t : temp)
                q.offer(t);
            if(q.isEmpty())
                break;
            time += k;

        }

        return time;
    }
}