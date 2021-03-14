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
    TreeNode temp = null;
    public TreeNode searchBST(TreeNode root, int val) {
        if(root != null){
            if(val == root.val){
                temp = root;
                return temp;
            }
            if(val > root.val)
                searchBST(root.right,val);
            if(val < root.val)
                searchBST(root.left,val);
        }
        return temp;
    }
}