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
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null) return head;
      var dummy = new ListNode(-1);
        dummy = head;
        ListNode temp = null;
        int size=1;
        while (dummy!=null){
            if(size == k)
                temp = dummy;
            dummy = dummy.next;
            size++;
        }
        dummy = head;
        size--;
        int kFromEnd = 1;
        while (kFromEnd <= size-k){
            dummy = dummy.next;
            kFromEnd++;
        }
        int swap = temp.val;
        temp.val = dummy.val;
        dummy.val = swap;
        return head;
    }
}
