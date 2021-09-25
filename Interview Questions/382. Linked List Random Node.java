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

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    Random rand;
    ListNode head;
    int len;
    public Solution(ListNode head) {
        rand = new Random();
        this.head = head;
        var cur = head;
        while(cur != null){
            cur = cur.next;
            len++;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int temp = rand.nextInt(len);
        var cur = head;
        while(temp != 0){
            cur = cur.next;
            temp--;
        }
        return cur.val;
    }
}


//without finding out length
class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    Random rand;
    ListNode head;
    public Solution(ListNode head) {
        rand = new Random();
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        var cur = head;
        int result = cur.val;
        cur = cur.next;
        for(int i = 1;cur != null;i++,cur = cur.next){
            if(rand.nextInt(i + 1) == i)
                result = cur.val;
        }
        return result;
    }
}
/