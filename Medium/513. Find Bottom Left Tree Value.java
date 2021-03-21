/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int value = 0;
    public int findBottomLeftValue(TreeNode root) {
        bfs(root);
        
        return value;
    }
    
    private void bfs(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            var tempRoot = q.peek();
            value = tempRoot.val;
            for(int i = 0;i<n;i++){
                tempRoot = q.remove();
                if(tempRoot.left != null)
                    q.offer(tempRoot.left);
                if(tempRoot.right != null)
                    q.offer(tempRoot.right);
            }
        }
    }
}