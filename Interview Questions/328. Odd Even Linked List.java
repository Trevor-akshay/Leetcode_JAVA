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
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyO = new ListNode();
        ListNode dummyE = new ListNode();
        ListNode tailO = dummyO, tailE = dummyE;
        int count=0;
        while (head != null) {
            count++;
        if (count%2 != 0) {
        tailO.next = head;
        tailO = tailO.next;
        } else {
        tailE.next = head;
        tailE = tailE.next;
        }
        head = head.next;
    }
        tailE.next = null;
        tailO.next = dummyE.next;
        return dummyO.next;
    }
}