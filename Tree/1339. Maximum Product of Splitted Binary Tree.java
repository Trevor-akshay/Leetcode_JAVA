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
    long totalTreeSum = 0;
    long maxProduct = 0;
    public int maxProduct(TreeNode root) {
        totalTreeSum = calTreeSum(root);
        findMaxProduct(root);
        
        return (int)(maxProduct % (int)(1e9 + 7));
    }
    
    private long calTreeSum(TreeNode root){
        if(root == null)
            return 0;
        long left = calTreeSum(root.left);
        long right = calTreeSum(root.right);
        
        return root.val + left + right;
    }
    
    private long findMaxProduct(TreeNode root){
        if(root == null)
            return 0;
        
        long left = findMaxProduct(root.left);
        long right = findMaxProduct(root.right);
        long tempTotalSum = left + right + root.val;
        maxProduct = Math.max(maxProduct,tempTotalSum * (totalTreeSum - tempTotalSum));
        
        return tempTotalSum;
    }
}