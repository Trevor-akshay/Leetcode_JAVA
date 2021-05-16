class Solution {
    public int[] memLeak(int memory1, int memory2) {
       int limit = 0;
        int leak = 1;
       while(true){
            limit++;
            if(memory1 >= memory2){
               if(memory1 - leak < 0)
                   break;
               memory1 -= leak;
            }else{
               if(memory2 - leak < 0)
                   break;
               memory2 -=leak;
            }
           leak++;
       }
        
        return new int[]{limit,memory1,memory2};
    }
}