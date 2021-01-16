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
         var temp = head;
        var copy = temp;
        var dummy = head.next;
        int length = 0; //  2  1   5
        while (temp!=null){
            int value = temp.val;
            while (dummy !=null){
                if(dummy.val > temp.val){
                    temp.val = dummy.val;
                    break;
                }
                dummy = dummy.next;
            }
            if(temp.val== value)
                temp.val = 0;
            length++;
            dummy = temp.next;
            temp = temp.next;
        }
       int[] result = new int[length];
        for(int i = 0;i<length;i++){
            result[i] = copy.val;
            copy = copy.next;
        }
        return result;
    }
}