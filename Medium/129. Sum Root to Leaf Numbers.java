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
    public int sumNumbers(TreeNode root) {
        dfs(root,new StringBuilder());
        return sum;
    }
    
    private void dfs(TreeNode root,StringBuilder s){
        if(root == null)
            return;
        s.append(root.val);
        dfs(root.left,s);
        dfs(root.right,s);
        if(root.left == null && root.right == null)
            sum += Integer.parseInt(s.toString());
        s.deleteCharAt(s.length()-1);
    }
}