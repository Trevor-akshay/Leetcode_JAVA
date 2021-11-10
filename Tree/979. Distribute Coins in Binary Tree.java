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
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }
    private int dfs(TreeNode root){
        if(root == null)
            return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        //every node should hve atleast 1 coin.so if node as 4 keep 1 and take 3 away;
        //if 0 you need one for this so take -1 to add up to the answer
        //if 1 you need zero for this
        res += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
            
    }
}