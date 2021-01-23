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
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        int length = 0;
        var temp = head;
        while(temp!=null){
            temp = temp.next;
            length++;
        }
    int[] array = new int[length];
        int ind = 0;
        while(head!=null){
            array[ind++] = head.val;
         head=  head.next;
        }
    for (int i = 0; i < array.length; i++) {
        int current = array[i]; // 3  1
        for (int j = 0; j < i; j++) {
            if(array[j] > current){
                int index = i;
                while (index!=j){
                 array[index] = array[index-1];
                 index--;
                }
                array[j] = current;
                break;
            }
        }
    }
        var dummy = new ListNode(-1);
        head = dummy;
        for(int i = 0;i<array.length;i++){
                dummy.next = new ListNode(array[i]);
            dummy = dummy.next;
        }
        return head.next;
    }
}