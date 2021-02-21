class Solution {
    public String restoreString(String s, int[] indices) {
       StringBuilder stringBuilder = new StringBuilder();
        char[] temp = new char[indices.length];
        int index = 0;
        for(char c : s.toCharArray()){
            temp[indices[index++]] = c;
        }
        for(char c:temp)
            stringBuilder.append(c);

        return stringBuilder.toString();
    }
}