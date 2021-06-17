class Solution {
    public int numRescueBoats(int[] people, int limit) {
       Arrays.sort(people);
        int left = 0,right=people.length-1;
        int boats = 0;
        while(left < right){
            int sum = people[left] + people[right];
            if(sum <= limit){
                people[left++] = -1;
                people[right--] = -1;
                boats++;
            }else
                right--;
        }
        for(int item : people)
            boats = item != -1? boats+1 : boats;

        return boats;
    }
}