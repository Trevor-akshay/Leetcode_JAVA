class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for(var item : barcodes)
            map.merge(item,1,Integer::sum);
        PriorityQueue<Map.Entry<Integer,Integer>> q = new PriorityQueue<>(
                (a,b) -> b.getValue() - a.getValue()
        );
        for(var entry : map.entrySet())
            q.offer(entry);
        int index = 0;
        while (!q.isEmpty()){
            barcodes[index] = q.peek().getKey();
            int temp = q.poll().getValue() - 1;
            var entry = Map.entry(barcodes[index++],temp);
            if(q.isEmpty())
                break;
            barcodes[index] = q.peek().getKey();
            int temp1 = q.poll().getValue() - 1;
            var entry1 = Map.entry(barcodes[index++],temp1);

            if(temp !=0)
                q.offer(entry);
            if(temp1 != 0 )
                q.offer(entry1);

        }
        return barcodes;
    }
}