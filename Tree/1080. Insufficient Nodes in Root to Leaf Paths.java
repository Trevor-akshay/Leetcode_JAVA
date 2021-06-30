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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        var res = dfs(root,limit,0);
        return res == false ? null : root;
    }
    
    private boolean dfs(TreeNode root,int limit,int sum){   
        sum = sum + root.val;
        if(root.left == null && root.right == null){
            if(sum >= limit)
                return true;
            return false;
        }
        boolean left = false,right = false;
        if(root.left != null)
            left = dfs(root.left,limit,sum);
        if(root.right != null)
            right = dfs(root.right,limit,sum);
        
        if(!left && !right)
            return false;
        
        if(!left)
            root.left = null;
        if(!right)
            root.right = null;
        
        return true;
    }
}