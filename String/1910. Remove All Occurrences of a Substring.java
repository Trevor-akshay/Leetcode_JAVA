class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder tmp = new StringBuilder(s);
        while (true){
            int left = s.indexOf(part);
            if(left == -1)
                break;
            tmp.delete(left,left + part.length());
            s = tmp.toString();
        }
        return tmp.toString();
    }
}