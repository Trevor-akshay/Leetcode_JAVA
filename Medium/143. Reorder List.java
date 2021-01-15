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
   public void reorderList(ListNode head) {
        if(head == null){
            return ;
        }
        ListNode curr = head;
        ListNode middleNode = getMiddleNode(head);
        if(middleNode == head){
            return ;
        }
        ListNode head2 = reverseNode(middleNode);
        mergeList(head, head2);
    }
    
    ListNode mergeList(ListNode head1, ListNode head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        ListNode next = head1.next;
        head1.next = head2;
        head1.next.next = mergeList(next, head2.next);
        return head1;
    }
    
    ListNode getMiddleNode(ListNode head){
        ListNode slw = head;
        ListNode fast = head;
        while(fast != null && fast.next != null && fast.next.next != null){
            slw = slw.next;
            fast = fast.next.next;
        }
        
        ListNode mid = slw.next != null? slw.next : slw;
        slw.next = null;
        return mid;
    }
    
    ListNode reverseNode(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
}