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
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root,Integer.MAX_VALUE,0);
        
        return res;
    }
    
    private void dfs(TreeNode root,int min,int max){
        if(root == null)
            return;
        min = Math.min(min,root.val);
        max = Math.max(max,root.val);
        dfs(root.left,min,max);
        res = Math.max(res,Math.max(Math.abs(root.val - min),Math.abs(root.val - max)));
        dfs(root.right,min,max);
    }
}