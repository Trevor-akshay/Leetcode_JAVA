class Solution {
    public List<String> stringMatching(String[] words) {
       var result = new HashSet<String>();
        Arrays.sort(words, Comparator.comparingInt(String::length).reversed());
        var sb = new StringBuilder();
        for (var w : words) {
            if (sb.indexOf(w) == -1) sb.append(w).append(";");
            else result.add(w);
        }
        return new ArrayList<>(result);
    }
}