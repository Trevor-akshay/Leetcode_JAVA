class Solution {
    public String freqAlphabets(String s) {
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            map.put(i, (char) (i + 96));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length();) {
            int temp = Integer.parseInt(s.charAt(i)+"");
            if (temp >= 3) {
                stringBuilder.append(map.get(temp));
                i++;
            }else if (i < s.length() - 2
                    && s.charAt(i+2) =='#'){
                String str = ""+temp+s.charAt(i+1);
                stringBuilder.append(map.get(Integer.parseInt(str)));
                i+=3;
            }else{
                stringBuilder.append(map.get(temp));
                i++;
            }

            }
        return stringBuilder.toString();
    }
}