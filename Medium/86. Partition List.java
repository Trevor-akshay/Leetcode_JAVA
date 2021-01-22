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
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        var dummy = new ListNode(-1);
        var temp = dummy;

        var current = head;
        while (current!=null){
            if(current.val < x){
                dummy.next = new ListNode(current.val);
                dummy = dummy.next;
            }
            current = current.next;
        }
        while (head!=null){
            if(head.val >= x){
                dummy.next = new ListNode(head.val);
                dummy = dummy.next;
            }
            head = head.next;
    }
            return temp.next;

    }
}