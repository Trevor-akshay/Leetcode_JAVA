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
    public TreeNode sortedArrayToBST(int[] nums) {
       
        TreeNode root = traverse(0,nums.length-1,nums);
        return root;
     }
    private TreeNode traverse(int start,int end,int[] nums){
        if(start > end)
            return null;
        int mid = (end+start) / 2;
        var root = new TreeNode(nums[mid]);
        root.left = traverse(start,mid-1,nums);
        root.right  = traverse(mid+1,end,nums);    
        
        return root;
    }
}