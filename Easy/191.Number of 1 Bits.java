public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
     int output = 0;
        String value = Integer.toBinaryString(n);
        for(char c : value.toCharArray())
            if(c == '1')
                output++;
        return output;
    }
}