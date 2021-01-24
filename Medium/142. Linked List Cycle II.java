/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
       if(head == null) return null;
        var slow = head;
        var fast = head;
        var flag = false;
        ListNode prev = null;
        while (fast!=null && fast.next!=null){
                        prev = slow;

            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                flag = true;
                break;
            }

        }
        if(flag == false) return null;
        var first  = head;
        var second = fast;
        while(first!=second){
            first = first.next;
            second = second.next;
        }
        return first;
    }
}