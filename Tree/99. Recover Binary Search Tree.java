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
    TreeNode first,second,third,prev;
    public void recoverTree(TreeNode root) {
        correctBSTUtil(root);
        
        if(first != null && third != null){
            int temp = first.val;
            first.val = third.val;
            third.val = temp;
        }else{
            int temp = second.val;
            second.val = first.val;
            first.val = temp;
        }
    }
    
    private void correctBSTUtil(TreeNode root){
        if( root != null )
        {
            correctBSTUtil( root.left);
 
            if (prev != null && root.val <
                                prev.val)
            {
                if (first == null)
                {
                    first = prev;
                    second = root;
                }
                else
                    third = root;
            }
 
            prev = root;
            correctBSTUtil( root.right);
        }   
    }
}