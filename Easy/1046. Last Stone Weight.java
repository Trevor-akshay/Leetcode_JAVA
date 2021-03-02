class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int item : stones){
            priorityQueue.add(item);
        }

        while(priorityQueue.size() > 1){//2 7 4 1 8 1
            int value = priorityQueue.remove();
            int value2 = priorityQueue.remove();
            if(value == value2)
                continue;
            priorityQueue.add(value - value2);
        }
        return  priorityQueue.isEmpty() ? 0 : priorityQueue.remove();
    }
}