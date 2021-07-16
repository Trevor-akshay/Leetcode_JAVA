class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String[]> q = new ArrayDeque<>();
        Set<String> strings = new HashSet<>(wordList);
        strings.remove(beginWord);
        q.offer(new String[]{beginWord,"0"});
        while (!q.isEmpty()){
            var polled = q.poll();
            String word = polled[0];
            int length = Integer.parseInt(polled[1]);
            if(word.equals(endWord)){
                return length + 1;
            }
            for(int i = 0;i<word.length();i++) {
                StringBuilder temp = new StringBuilder(word);
                for (int j = 0; j < 26; j++) {
                    char c = (char) ('a' + j);
                    temp.deleteCharAt(i);
                    temp.insert(i,c);
                    if(strings.contains(temp.toString())) {
                        int newLength = length + 1;
                        strings.remove(temp.toString());
                        q.offer(new String[]{temp.toString(),newLength+""});
                    }
                }
            }
        }

        return 0;
    }
}