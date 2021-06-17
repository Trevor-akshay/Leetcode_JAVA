class Solution {
    public String[] getFolderNames(String[] names) {
      Map<String, Integer> map = new HashMap<>();
        String[] ans = new String[names.length];
        int i = 0;
        for (String s : names) {
            int cnt = map.getOrDefault(s, 0);
            if (cnt == 0) {
                ans[i++] = s;
                map.put(s, 1);
            } else {
                String tmp = s + "(" + cnt + ")";
                while (map.containsKey(tmp)) {
                    tmp = s + "(" + (++cnt) + ")";
                }
                ans[i++] = tmp;
                map.put(tmp, 1);
                map.put(s, cnt + 1);
            }
        }
        return ans;
}
}