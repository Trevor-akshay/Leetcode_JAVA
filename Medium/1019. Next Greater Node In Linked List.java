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
    public int[] nextLargerNodes(ListNode head) {
      int length = 0;
        var current = head;
        while (current!=null){
            length++;
            current = current.next;
        }
        int[] clone = new int[length];
        int index = 0;
        while (head!=null){
            clone[index++]  = head.val;
            head = head.next;
        }
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();
        for(int i = length-1;i>=0;i--){ // 2  1  5
            int element = clone[i];
            while (!stack.empty() && element >= stack.peek()){
                stack.pop();
            }
            if(stack.empty()){
                result[i] = 0;
            }else
                result[i] = stack.peek();

            stack.push(clone[i]);
        }

        return result;
    }
}
