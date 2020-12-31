class Solution {
    public int reverse(int x) {
       String value = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder();
        boolean negative = false;
        try {
            if (value.charAt(0) == '-') {
                negative = true;
            }
            if (negative) {
                for (int i = value.length() - 1; i > 0; i--) {
                    stringBuilder.append(value.charAt(i));
                }
                int result = Integer.parseInt(stringBuilder.toString());
                result = result * -1;
                return result;
            }
            for(int i = value.length()-1;i>=0;i--)
                stringBuilder.append(value.charAt(i));
            return (int) Integer.parseInt(stringBuilder.toString());
        }catch (NumberFormatException e){
            return 0;
        }
}}