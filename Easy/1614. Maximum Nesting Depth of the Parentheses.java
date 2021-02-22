class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
		int temp = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				temp++;
			} else if (s.charAt(i) == ')') {
				maxDepth = Math.max(maxDepth, temp);
				temp--;
			}
		}

		return maxDepth;
    }
}