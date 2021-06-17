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
    int difference = 0;
    public int findTilt(TreeNode root) {
        if(root == null)
            return difference;
        findTiltHelper(root);
        return difference;
    }

    private int findTiltHelper(TreeNode root){
        if(root ==null)
            return 0;
        int left = findTiltHelper(root.left);
        int right = findTiltHelper(root.right);
        
        difference += Math.abs(left - right);

        return left + right + root.val;
    }
}