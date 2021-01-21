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
          ListNode dummy=new ListNode();
        dummy.next=head;
        
        ListNode firstChange=new ListNode();
        ListNode secondChange=new ListNode();
        secondChange=head;
        
        while(k-->0){
          firstChange=head;
          head=head.next;  
        }
        
        while(head!=null){
          secondChange=secondChange.next;
          head=head.next;
        }
        
        swap(firstChange,secondChange);
        
        return dummy.next;
    }
    
    public void swap(ListNode firstChange,ListNode secondChange){
        int temp=firstChange.val;
        firstChange.val=secondChange.val;
        secondChange.val=temp;
    }
}