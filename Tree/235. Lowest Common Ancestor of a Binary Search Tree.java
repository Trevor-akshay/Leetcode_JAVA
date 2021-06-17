/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root,p.val,q.val);
    }
    private TreeNode dfs(TreeNode root,int p,int  q) {
        if(root.val > p && root.val > q)
            return dfs(root.left,p,q);
        else if(root.val < p && root.val< q)
            return dfs(root.right,p,q);
        else
            return root;
    }
}