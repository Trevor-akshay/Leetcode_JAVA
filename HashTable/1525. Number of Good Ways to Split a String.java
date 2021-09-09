class Solution {
    public int numSplits(String s) {
        Map<Character, Integer> left = new HashMap<>();
        Map<Character, Integer> right = new HashMap<>();

        left.put(s.charAt(0), 1);
        for (int i = 1; i < s.length(); i++)
            right.merge(s.charAt(i), 1, Integer::sum);

        int count = 0;
        if (left.size() == right.size())
            count++;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            left.merge(c, 1, Integer::sum);
            int temp = right.get(c);
            if (temp == 1)
                right.remove(c);
            else
                right.put(c, temp - 1);
            
            count += left.size() == right.size() ? 1 : 0;
        }

        return count;
    }
}