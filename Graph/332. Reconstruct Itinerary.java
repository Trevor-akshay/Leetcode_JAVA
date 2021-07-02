class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
         Map<String,PriorityQueue<String>> map = new HashMap<>();
         for(var ticket : tickets){
             map.putIfAbsent(ticket.get(0),new PriorityQueue<>());
             map.get(ticket.get(0)).offer(ticket.get(1));
         }
        
         List<String> list = new LinkedList<>();
         Stack<String> stack = new Stack<>();
         stack.push("JFK");

         while(!stack.empty()){
             var top = stack.peek();
             if(map.get(top) == null || map.get(top).size() == 0)
                 list.add(0,stack.pop());
             else
                stack.push(map.get(top).poll());
         }

         return list;
    }
}