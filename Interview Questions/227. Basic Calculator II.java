class Solution {
    public int calculate(String str) {
     int n = str.length();
    Stack<Integer> stack = new Stack<>();
    char previousSign = '+';
    for (int i = 0; i < n; i++) {
      char c = str.charAt(i);
      if (c == ' ')
        continue;
      
      if (Character.isDigit(c)) {
        int j = getTrailingDigitIndex(str, i);
        int number = Integer.parseInt(str.substring(i, j));
        switch (previousSign) {
          case '+':
            stack.push(number);
            break;
          case '-':
            stack.push(-number);
            break;
          case '*':
            stack.push(stack.pop() * number);
            break;
          case '/':
            stack.push(stack.pop() / number);
            break;
        }
        
        i = j - 1;
      } else {
        previousSign = str.charAt(i);
      }
    }
    
    int result = 0;
    while (!stack.isEmpty())
      result += stack.pop();
    
    return result;
  }
  
  private int getTrailingDigitIndex(String str, int i) {
    int n = str.length();
    while (i < n && Character.isDigit(str.charAt(i)))
      i++;
    return i;
  }
}