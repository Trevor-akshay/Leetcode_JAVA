class Solution {
    public int maximum69Number (int num) {
        int max = num;
        String value = num+"";
        for(int i = 0;i<value.length();i++){
            StringBuilder temp = new StringBuilder(value);
            char c = temp.charAt(i);
            if(c == '6'){
                temp.replace(i,i+1, "9");
                max = Math.max(max,Integer.parseInt(temp.toString()));
                break;
            }
        }

        return max;
    }
}