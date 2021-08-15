class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] order = preorder.split(",");
        int degree = 1;
        for(var str : order){
            if(--degree < 0)
                return false;
            if(!str.equals("#"))
                degree+=2;
        }
        
        return degree == 0;
    }
}