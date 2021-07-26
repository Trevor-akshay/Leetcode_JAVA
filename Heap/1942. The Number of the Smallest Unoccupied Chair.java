class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int[][] array = new int[times.length][3];
        PriorityQueue<Integer> chairs = new PriorityQueue<>();
        for(int i = 0;i<times.length;i++){
            array[i] = new int[]{times[i][0],times[i][1],i};
            chairs.offer(i);
        }
        //[0] = startTime , [1] = endTime & [2] = idx
        Arrays.sort(array,(a,b) -> a[0] - b[0]);

        //[0] = endTime && [1] = idx
        PriorityQueue<int[]> leavingTime = new PriorityQueue<>(
                (a,b) -> a[0] - b[0]
        );
        for(var arr : array){
            while (!leavingTime.isEmpty() && leavingTime.peek()[0] <= arr[0]){
                chairs.offer(leavingTime.poll()[1]);
            }
            if(arr[2] == targetFriend)
                return chairs.poll();

            leavingTime.offer(new int[]{arr[1],chairs.poll()});
        }
        
        return -1;
    }
}