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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || head == null || head.next == null) return head;
        var result = new ListNode(-1);
        var dummy = result;
        while (head!=null){
            var reverse = new ListNode(-1);
            var toRev = reverse;
            int temp = k+1;
            while (head!=null && temp!=1){
                reverse.next = new ListNode(head.val);
                reverse = reverse.next;
                head = head.next;
                temp--;
            }
            if(temp == 1){
                reverse = reverse(toRev.next);
                while (reverse!=null){
                    result.next = new ListNode(reverse.val);
                    result = result.next;
                    reverse = reverse.next;
                }
            }
            else{
                toRev = toRev.next;
                while (toRev!=null){
                    result.next = new ListNode(toRev.val);
                    result = result.next;
                    toRev = toRev.next;
                }
            }
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head){
        var curent = head;
        ListNode prev = null,next = null;
        while (curent!=null){
            next = curent.next;
            curent.next = prev;
            prev = curent;
            curent = next;
        }
        return prev;
    }
}