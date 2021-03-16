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
    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        sumRootToLeaf(root,new StringBuilder());
        return  sum;
    }

    private void sumRootToLeaf(TreeNode root,StringBuilder s) {
        if(root == null)
            return;
        s.append(root.val);
        sumRootToLeaf(root.left,s);
        sumRootToLeaf(root.right,s);
        if(root.left == null && root.right == null){
            sum += Integer.parseInt(s.toString(),2);
        
        }
        s.deleteCharAt(s.length()-1);
    }
}