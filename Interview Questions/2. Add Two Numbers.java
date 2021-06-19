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
    public ListNode addTwoNumbers(ListNode head, ListNode otherHead) {
        int sum = 0;
        int count  = 0;
        var temp = new ListNode(-1);
        var dummy = temp;
        while (head!=null && otherHead!=null){
            sum = head.val+otherHead.val+count;
            count = sum >= 10?1:0;
            sum %=10;
            temp.next = new ListNode(sum);
            temp = temp.next;
            head = head.next;
            otherHead= otherHead.next;
            if(head == null && otherHead == null && count == 1){
                temp.next = new ListNode(count);
            }
        }

        while (head!=null){
            sum = head.val + count;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            head = head.next;
            count = sum >= 10 ? 1 : 0;
            if(head == null && count == 1){
                temp.next = new ListNode(1);
            }
        }
        while (otherHead!=null){
            sum = otherHead.val+count;
            temp.next = new ListNode(sum%10);
            temp = temp.next;
            otherHead = otherHead.next;
            count = sum >= 10 ? 1 : 0;
            if(otherHead == null && count == 1){
                temp.next = new ListNode(1);
            }
        }
        return dummy.next;
    }
}