class Solution {
    public int[] singleNumber(int[] nums) {
        int n1_n2 = 0;
        for(int num : nums)
            n1_n2 ^= num;
        int rightBit = 1;
        while((n1_n2 & rightBit) == 0)
            rightBit <<= 1;
        int xor1 = 0;
        int xor2 = 0;
        
        for(int item : nums){
            if((item & rightBit) == 0)    
                xor2 ^= item;
            else 
                xor1 ^= item;
        }
        return new int[]{xor1,xor2};
    }
                                  // 6 0  1  1  0
                                  // 1 0  0  0  1
                                  // 3 0  0  1  1
                                  // 5 0  1  0  1
}