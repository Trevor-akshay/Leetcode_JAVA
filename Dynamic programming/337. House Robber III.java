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
    Map<TreeNode,Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        return helper(root);
    }
    
    private int helper(TreeNode root){
        if(root == null)
            return 0;
        
        if(!memo.containsKey(root)){
             int rob = root.val + (root.left == null ? 0 : 
                             helper(root.left.left) + helper(root.left.right));
        
             rob += root.right  == null ? 0 : 
                             helper(root.right.left) + helper(root.right.right);
        
             int skipRob = helper(root.left) + helper(root.right);
            
             memo.put(root,Math.max(rob,skipRob));
        }
        return memo.get(root);
    }
}