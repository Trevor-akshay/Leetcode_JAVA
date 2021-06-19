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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) head = null;
        var temp = head;
        int length = 0;
        
        while (temp!=null){
            length++;
            temp = temp.next;
        }
        int point = length-n;
        length =0;
        if(point == 0){
            head = head.next;
            return head;
        }
        var current = head;
        while (current!=null){
            length++;
            if (length == point){
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
        return head;
    }
}