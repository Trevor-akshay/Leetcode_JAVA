class Solution {
    public int myAtoi(String s) {
    
        final  char WHITE_SPACE = ' ';
        final  char ZERO = '0';
        final  char NINE = '9';
        final  char NEGATIVE_SIGN = '-';
        final  char POSITIVE_SIGN = '+';
            if (s == null && s.length() == 0) {
                return 0;
            }
            int pos = 0;

            while (pos < s.length() && s.charAt(pos) == WHITE_SPACE) {
                pos++;
            }

            if (pos == s.length()) {
                return 0;
            }
            char firstChar = s.charAt(pos);
            boolean isNegative = false;

            if (firstChar >= ZERO && firstChar <= NINE) {
            } else if (firstChar == POSITIVE_SIGN) {
                pos++;
            } else if (firstChar == NEGATIVE_SIGN) {
                pos++;
                isNegative = true;
            } else {
                return 0;
            }

            if (pos == s.length()) {
                return 0;
            }

            char nextChar = s.charAt(pos);

            int result = 0;

            if (nextChar >= ZERO && nextChar <= NINE) {
                result = nextChar - ZERO;
            } else {
                return 0;
            }

            ++pos;

            int max = Integer.MAX_VALUE / 10;

            int carry = isNegative ? Math.abs(Integer.MIN_VALUE % 10) : Integer.MAX_VALUE % 10;
            
            while (pos < s.length()) {
                char ch = s.charAt(pos);
                if (ch >= ZERO && ch <= NINE) {
                    int val = ch - ZERO;
                    if (result < max || (result == max && val <= carry)) {
                        result = result * 10 + val;
                    } else {
                        return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    }
                 } else {
                    break;
                }
                pos++;
            }
            return isNegative ? result * -1 : result;
        
    }
}