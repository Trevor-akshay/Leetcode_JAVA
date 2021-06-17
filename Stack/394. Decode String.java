class Solution {
    public String decodeString(String s) {
      Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stack.push("[");
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder(stack.pop());
                while (!stack.peek().equals("[")) {
                    temp.insert(0, stack.pop());
                }
                stack.pop();
                int num = Integer.parseInt(stack.pop());
                StringBuilder sb = new StringBuilder();
                while (num > 0) {
                    sb.append(temp.toString());
                    num--;
                }
                stack.push(sb.toString());

            } else if (c >= '0' && c <= '9') {
                int num = -1;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    if (num == -1) {
                        num = s.charAt(i) - '0';

                    } else {
                        num = (num * 10) + (s.charAt(i) - '0');
                    }
                    i++;
                }
                i--;
                stack.push(String.valueOf(num));
            } else {

                StringBuilder sb = new StringBuilder();

                while (i < s.length() && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                    sb.append(s.charAt(i));
                    i++;
                }
                stack.push(sb.toString());
                i--;
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}