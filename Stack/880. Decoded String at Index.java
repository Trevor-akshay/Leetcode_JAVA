class Solution {
    public String decodeAtIndex(String S, int K) {
    long size = 0; 
		int n = S.length();

		for(char c : S.toCharArray()) {
			if(Character.isDigit(c)){
				size = size * (c-'0');
			}
			else {
				size++;
			}
		}

		for(int i = n-1; i >= 0; i--) {
			char c= S.charAt(i);
			K%=size;
			if((K == 0 || K == size) && Character.isLetter(c)){
				return Character.toString(c);
			}
			if(Character.isDigit(c)){
				size = size / (c-'0');
			}
			else {
				size--;
			}
		}

		return null;
}}