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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        var current = new ListNode(0);
        var temp  = current;
        while (head!=null){
            if(head.val == val){
                head = head.next;
                continue;
            }
            current.next = new ListNode(head.val);
            current = current.next;
            head = head.next;
        }
        return temp.next;
    }
}