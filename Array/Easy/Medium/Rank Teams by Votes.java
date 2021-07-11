class Solution {
    public String rankTeams(String[] votes) {
         int m = votes.length, n = votes[0].length();
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = votes[i].charAt(j);
                map.computeIfAbsent(c, k -> new int[n]);
                map.get(c)[j]++;
            }
        }
        List<Character> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (a, b) -> {
            for (int i = 0; i < n; i++) {
                if (map.get(b)[i] != map.get(a)[i]) return map.get(b)[i] - map.get(a)[i];
            }
            return 0;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keys.size(); i++) {
            sb.append(keys.get(i));
        }
        return sb.toString();
    }
}