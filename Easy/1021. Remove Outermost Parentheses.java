class Solution {
    public String removeOuterParentheses(String S) {
        int leftBracket = 0;
	StringBuilder result = new StringBuilder();
	char[] input = S.toCharArray();
	for(int i=0; i<input.length; i++ ) {
		char currChar = input[i];
		//Outer Bracket Start
		if(currChar == '(') {
			if(leftBracket != 0) {
				result.append(currChar);
			}
			leftBracket ++;
		} else {
			leftBracket --; //Left bracket getting cancelled with right bracket
			if(leftBracket != 0) {
				result.append(currChar);
			}
		}
	}
	return result.toString();
    }
}