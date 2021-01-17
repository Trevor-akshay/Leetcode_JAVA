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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        for (ListNode list : lists) {
           var curent = list;
            head = merge(head, curent);
        }
       
        return head.next;
    }

    private ListNode merge(ListNode head1,ListNode head2){
        ListNode result = new ListNode(-1);
        var temp = result;
        while (head1!=null && head2!=null){
            if(head1.val < head2.val){
                result.next = new ListNode(head1.val);
                result = result.next;
                head1 = head1.next;
            }else{
                result.next = new ListNode(head2.val);
                result = result.next;
                head2 = head2.next;
            }
        }
        while (head1!=null){
            result.next = new ListNode(head1.val);
            result = result.next;
            head1 = head1.next;
        }
        while (head2!=null){
            result.next = new ListNode(head2.val);
            result = result.next;
            head2 = head2.next;
        }
        return temp.next;
    }
}