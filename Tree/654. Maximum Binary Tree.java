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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
       return helper(nums,0,nums.length-1);
    }
    
    private TreeNode helper(int[] nums,int left,int right){
        if(left > right)
            return null;
        
        int index = left;
        for(int i = left;i<=right;i++)
            index = nums[index] < nums[i] ? i : index;

        TreeNode root = new TreeNode(nums[index]);
        root.left = helper(nums,left,index-1);
        root.right = helper(nums,index+1,right);
        
        return root;
    }
}