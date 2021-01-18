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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head.next == null) return head;
        var result = new ListNode(-1);
        var dummy = result;
        int firstpointer = 1;
        while (firstpointer!=m){
            result.next = new ListNode(head.val);
            firstpointer++;
            result = result.next;
            head = head.next;
        }

        var reversedList =new ListNode(-1);
        var tempReversed = reversedList;
        while (firstpointer<=n){
            reversedList.next = new ListNode(head.val);
            reversedList = reversedList.next;
            head = head.next;
            firstpointer++;
        }
        reversedList = reverse(tempReversed.next);
        result.next = reversedList;
        firstpointer = n-m+1;
        while (firstpointer!=0){
            result = result.next;
            firstpointer--;
        }
        result.next = head;
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head){
        var dummy = head;
        ListNode prev = null;
        ListNode next = null;
        while(dummy !=null){
            next = dummy.next;
            dummy.next = prev;
            prev = dummy;
            dummy = next;
        }
        
        return prev;
    }
}