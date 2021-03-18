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
    public TreeNode insertIntoBST(TreeNode root, int value) {
        TreeNode treeNode = new TreeNode(value);
        if (root == null) {
            root = treeNode;
            return root;
        }
        var current = root;
        while (true) {
            if (value > current.val) {
                if (current.right == null) {
                    current.right = treeNode;
                    break;
                }
                current = current.right;
            } else {
                if (current.left == null) {
                    current.left = treeNode;
                    break;
                }
                current = current.left;
            }
        }
        return root;
    }
}