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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        var dummy = list1;
        var temp = list1;
         int length = 0;


        while(length!=a){
            length++;
            dummy = dummy.next;
            temp = temp.next;
        }
        while (length <= b){
            length++;
            temp = temp.next;
        }
        dummy.val = list2.val;
        while (list2.next!=null){
            dummy.next = new ListNode(list2.next.val);
            dummy = dummy.next;
            list2 = list2.next;
        }
        dummy.next = temp;
        return list1;

    }
}