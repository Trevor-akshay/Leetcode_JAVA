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
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root,root.val);
    }
    private boolean isUnivalTree(TreeNode root,int value){
        if(root == null)
            return true;
        if(root.val != value)
            return false;
        
        return root.val == value && isUnivalTree(root.left,value) && 
            isUnivalTree(root.right,value);
    }
}