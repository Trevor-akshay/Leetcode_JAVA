/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        var cur = head;
        Map<Node,Node> map = new HashMap<>();
        while(cur!=null){
            var temp = new Node(cur.val);
            map.put(cur,temp);
            cur = cur.next;
        }
        
        cur = head;
        while(cur!=null){
            var temp = map.get(cur);
            temp.next = map.getOrDefault(cur.next,null);
            temp.random = map.getOrDefault(cur.random,null);
            cur = cur.next;
        }
        
        return map.get(head);
    }
}