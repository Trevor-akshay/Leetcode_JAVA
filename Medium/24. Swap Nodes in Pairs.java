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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        var temp = head;
        var tempNext = head.next;
        while (tempNext!=null && tempNext.next!=null){
            int swap = temp.val;
            temp.val = tempNext.val;
            tempNext.val = swap;
             temp = tempNext.next;
            tempNext = temp.next;
        }
        if(tempNext!=null) {
            int swap = temp.val;
            temp.val = tempNext.val;
            tempNext.val = swap;
        }
        return head;
    }
}