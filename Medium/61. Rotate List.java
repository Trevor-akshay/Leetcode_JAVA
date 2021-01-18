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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0 || head.next == null) return head;
        var current = head;
        int length = 0;
        while (current!=null){
            length++;
            current = current.next;
        }
        if( k > length) k= k%length;
        else if(k == length) return head;

        var secondHead = new ListNode(-1);
        var headpointer = secondHead;
        while (length!=k){
            secondHead.next = new ListNode(head.val);
            secondHead = secondHead.next;
            head = head.next;
            length--;
        }
        var firstHead = new ListNode(-1);
        var result = firstHead;
        while (head!=null){
            firstHead.next = new ListNode(head.val);
            head = head.next;
            firstHead = firstHead.next;
        }
        firstHead.next = headpointer.next;
        return result.next;
    }
}