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
    public List < Integer > inorderTraversal(TreeNode root) {
       ArrayList<Integer> list = new ArrayList<>();
       inorder(root,list);
       return list;
   }
   private void inorder(TreeNode root,ArrayList<Integer> list){
       if(root == null)
            return;
       inorder(root.left,list);
       list.add(root.val);
       inorder(root.right,list);
   }
   
}