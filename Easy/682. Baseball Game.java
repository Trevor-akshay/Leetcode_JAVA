class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for(var op : ops){
            switch (op) {
                case "C":
                    stack.pop();
                    break;
                case "D": {
                    var item = stack.peek();
                    stack.push(item * 2);
                    break;
                }
                case "+": {
                    var item = stack.pop();
                    var item2 = stack.pop();
                    stack.push(item2);
                    stack.push(item);
                    stack.push(item + item2);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(op));
                    break;
            }
        }
        int sum = 0;
        while (!stack.empty())
            sum+=stack.pop();
        return sum;
    }
}