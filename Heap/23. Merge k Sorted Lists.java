/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
         PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(var l : lists){
            if(l != null)
                q.offer(l);
        }
        ListNode result = new ListNode();
        var dummy = result;
        while(!q.isEmpty()){
            var temp = q.poll();
            result.next = new ListNode(temp.val);
            result = result.next;
            if(temp.next != null)
                q.offer(temp.next);
        }
        return dummy.next;
    }
}