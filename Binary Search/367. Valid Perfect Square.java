class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;
        while(left < right){
            long mid = (left + right) / 2;
            long value = mid * mid;
            if(mid * mid == num)
                return true;
            else if(mid * mid > num)
                right = mid;
            else
                left = mid + 1;
        }
        return num == 1 || false;
    }
     // 1  2  3  4  5  6   8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
    //  L                                M                                    R
}