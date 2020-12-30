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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       ListNode result = new ListNode(-1);
        ListNode dummy = result;
        
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else{
                result.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            result = result.next;
        }
        
        while(l1 != null){
            result.next = new ListNode(l1.val);
            l1 = l1.next;
            result = result.next;
        }
        
        while(l2 != null){
            result.next = new ListNode(l2.val);
            l2 = l2.next;
            result = result.next;
        }
        
        return dummy.next;
    }
}