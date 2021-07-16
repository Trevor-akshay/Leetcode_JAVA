class Solution {
   int min =Integer.MAX_VALUE;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
       List<List<String>> result = new ArrayList<List<String>>();

        Set<String> set = new HashSet<String>(wordList);
        if (!set.contains(endWord))
            return result;

        Queue<List<String>> q = new LinkedList<List<String>>();
        q.offer(Arrays.asList(beginWord));
        boolean find = false;
        
        while (!q.isEmpty() && !find) {
            int size = q.size();
            Set<String> toDelete = new HashSet<String>();
            while (size-- > 0) {
                List<String> path = new ArrayList<String>(q.poll());
                char[] curr = path.get(path.size() - 1).toCharArray();
                for (int i = 0; i < curr.length; ++i) {
                    char backup = curr[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        curr[i] = c;
                        String next = new String(curr);
                        if (set.contains(next)) {
                            path.add(next);
                            q.offer(new ArrayList<String>(path));
                            if (next.equals(endWord)) {
                                result.add(new ArrayList<String>(path));
                                find = true;
                            }
                            path.remove(path.size() - 1);
                            toDelete.add(next);
                        }
                    }
                    curr[i] = backup;
                }
            }
            for (String word : toDelete) {
                set.remove(word);
            }
        }
        return result;
    }
}