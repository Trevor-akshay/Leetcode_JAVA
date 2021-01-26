/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Stack<Node> stk=new Stack();
        Node cur=head;
        while(cur!=null)
        {
            if(cur.child!=null)
            {
                if(cur.next!=null) 
                    stk.push(cur.next);  
                cur.next=cur.child; 
                cur.next.prev=cur;  
                cur.child=null; 
            }
            else if(cur.next==null && !stk.empty()) 
            {
                cur.next=stk.pop(); 
                cur.next.prev=cur; 
            }
            cur=cur.next;  
        }
        return head;
    }
}