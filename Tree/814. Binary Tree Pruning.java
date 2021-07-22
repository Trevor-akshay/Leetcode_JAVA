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
    public TreeNode pruneTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode head = new TreeNode(root.val);
        head.left = pruneTree(root.left);
        head.right = pruneTree(root.right);
        if(head.val == 0 && head.left == null && head.right == null)
            return null;
        
        return head;    
    }
  
}