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
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> temp = new HashSet<>();
        for(var items : G)
            temp.add(items);
        int count = 0;//0 1 2 3    0 1 3
        while (head!=null){
            boolean flag = false;
            while (head!=null && temp.contains(head.val)){
                head = head.next;
                flag = true;    
            }
           
            count = flag ? count +1 : count;
            
            head = head != null ? head.next : null;
        }
        return count;
    }
}