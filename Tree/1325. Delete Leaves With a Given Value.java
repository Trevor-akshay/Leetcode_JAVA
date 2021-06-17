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
    //TreeNode result = null;
    //TreeNode temp = result;
    boolean flag = true;
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(!flag)
            return root;
        flag = false;
        var current = root;
        return remove(current,target);
        
    }
    private TreeNode remove(TreeNode root,int target){
        if(root == null)
            return null;
        root.left  = remove(root.left,target);
        root.right = remove(root.right,target);
        
        if(root.left == null && root.right == null && root.val == target){
            flag = true;
            return null;
        }
        return root;
    }
    
}