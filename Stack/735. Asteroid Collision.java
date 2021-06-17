class Solution {
    public int[] asteroidCollision(int[] asteroids) {
     
    Deque<Integer> stack = new ArrayDeque<>();
       for (int asteroid : asteroids) {
           if (stack.isEmpty())
               stack.addFirst(asteroid);
           else {
               int curr = asteroid;
               while (!stack.isEmpty() && curr != 0 && curr * stack.getFirst() < 0 && stack.getFirst() > 0) {
                   if (Math.abs(curr) == stack.getFirst()) {
                       curr = 0;
                       stack.removeFirst();
                       continue;
                   }
                   int max = Math.max(stack.getFirst(), curr);
                   int temp = Math.max(Math.abs(stack.removeFirst()), Math.abs(curr));
                   curr = temp == max ? temp : -temp;
               }
               if (curr != 0) stack.addFirst(curr);
           }
       }
       int[] result = new int[stack.size()];
       while(!stack.isEmpty()) 
           result[stack.size() - 1] = stack.removeFirst();
       return result;
    }
}