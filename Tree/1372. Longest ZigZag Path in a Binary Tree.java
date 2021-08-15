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
    int max = 0;
    public int longestZigZag(TreeNode root) {
        if(root == null)
            return 0;
        calMax(root,0,true);
        calMax(root,0,false);
        return max;
    }
    private void calMax(TreeNode root,int temp,boolean isRight){
        if(root == null){
            return;
        }
        max = Math.max(temp,max);
        if(isRight){
            calMax(root.left,1,true);
            calMax(root.right,temp + 1,false);
        }else{
            calMax(root.left,temp + 1,true);
            calMax(root.right,1,false);
        }
    }
}