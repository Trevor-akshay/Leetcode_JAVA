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
    Queue<TreeNode> q = new LinkedList<>();
    public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return;
        dfs(root);
        while(!q.isEmpty()){
            root.left = null;
            root.right = q.remove();
            root = root.right;
        }
    }
    
   
    private void dfs(TreeNode root){
        if(root == null)
            return;
        q.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}