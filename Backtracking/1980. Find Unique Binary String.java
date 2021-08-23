class Solution {
    boolean found = false;
    String res = " ";
    public String findDifferentBinaryString(String[] nums) {
        int len = nums[0].length();
        StringBuilder value = new StringBuilder("0".repeat(len));
        Set<String> set = new HashSet<>(Arrays.asList(nums));
        helper(0,value,set);

        return res;
    }

    private void helper(int index,StringBuilder value,Set<String> set){
        if(!set.contains(value.toString())){
            found = true;
            res = value.toString();
            return;
        }
        for(int i = index;i<value.length();i++){
            if(found)
                break;
            char c = value.charAt(i);
            if(c == '0')
                value.setCharAt(i,'1');
            else
                value.setCharAt(i,'0');
            helper(i+1,value,set);
        }
}
}