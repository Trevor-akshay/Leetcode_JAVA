/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        bfs(root);
        return root;
    }
    private void bfs(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            var temp = new Node();

            for(int i = 0;i<n;i++){
                var tempRoot = q.remove();
                temp = tempRoot;
                if(tempRoot.left != null)
                    q.offer(tempRoot.left);
                if(tempRoot.right != null)
                    q.offer(tempRoot.right);
                tempRoot.next = q.peek();
            }
            temp.next = null;
        }
    }
}