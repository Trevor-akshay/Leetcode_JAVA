class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
         char item = keysPressed.charAt(0) ;
        int value = releaseTimes[0]; // 12
        for(int i = 1;i<releaseTimes.length;i++){//12,23,36,46,62    s p u d a
            if(releaseTimes[i] - releaseTimes[i-1] > value){ //62 - 46 = 16
                value = releaseTimes[i] - releaseTimes[i-1];//16
                item = keysPressed.charAt(i);//a
            }
            else if(releaseTimes[i] - releaseTimes[i-1] == value){
                if(keysPressed.charAt(i) > keysPressed.charAt(i-1))
                    item = keysPressed.charAt(i);
                else
                    item = keysPressed.charAt(i-1);
            }
            else
                continue;
        }
        return item;
    }
}