class Solution {
    public String longestCommonPrefix(String[] strs) {
        String shortestStr = "";
	int minLen = Integer.MAX_VALUE;
	for (String str : strs) {
		if (str.length() < minLen) {
			minLen = str.length();
			shortestStr = str;
		}
	}
	for (String str : strs) {
		while (!str.startsWith(shortestStr)) {
			shortestStr = shortestStr.substring(0, minLen - 1);
			minLen--;
		}
	}
	return shortestStr;
    }
}