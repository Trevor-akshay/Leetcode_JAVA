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
    public ListNode removeZeroSumSublists(ListNode head) {
		if(head==null){
			return head;
			}
		ListNode result = new ListNode();//1,2,-3,3,1]
        ListNode prev = result;
        result.next =  head;

        while (head!=null){
            var cur = head;
            int sum = 0;
            boolean found = false;
            while(cur != null){
                sum += cur.val;
                cur = cur.next;

                if(sum == 0){
                    found = true;
                    break;
                }
            }
            if(found){
                prev.next =cur;
                head = cur;
               continue;
            }
			
            prev = head;
            head = head.next;
        } 
        return result.next;
    }
}