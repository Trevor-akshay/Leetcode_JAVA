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
    public ListNode[] splitListToParts(ListNode root, int k) {
       ListNode[] result = new ListNode[k]; 
        int size = 0;
        ListNode head = root;
        while (head != null) {
            head = head.next;
            size++;
        }
        int extra = size % k;
        ListNode curr = root;
        for (int i = 0; i < k; i++) {
            if (curr == null) {
                result[i] = null;
                continue;
            }
            int partitionSize = (size / k)  + (extra > 0 ? 1 : 0);
            result[i] = curr;
            ListNode prev = curr;
            while (partitionSize > 0 && curr != null) {
                prev = curr;
                curr = curr.next;
                partitionSize--;
            }
            prev.next = null;
            extra--;
        }
        return result;
    }
    
}