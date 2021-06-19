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
    TreeNode temp = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         dfs(root,p.val,q.val);
        return temp;
    }
    
    private boolean dfs(TreeNode root,int p,int q){
        if(root == null)
            return false;
        int left = dfs(root.left,p,q) ? 1 : 0;
        int right = dfs(root.right,p,q) ? 1 : 0;
        
        int mid = (root.val == p || root.val == q) ? 1 : 0;
        
        if(left + right + mid >= 2)
            temp = root;
        return (left + right +mid > 0) ;
            
        }
}
