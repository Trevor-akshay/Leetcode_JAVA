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
    public ListNode deleteDuplicates(ListNode head) {
         if(head == null || head.next == null) return head;
        var current = head;//1  1  2  3  3
        var prev = new ListNode(Integer.MAX_VALUE); //0 1 2 3
        var temp = prev;
        while (current!=null){
            if(current.val == prev.val){
                current = current.next;
                }else {
            prev.next = new ListNode(current.val);
            prev = prev.next;
            current = current.next;
            }
        }
            return temp.next;
        }
    }
