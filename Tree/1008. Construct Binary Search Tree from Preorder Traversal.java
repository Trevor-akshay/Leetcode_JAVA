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
    TreeNode root = null;
    public TreeNode bstFromPreorder(int[] preorder) {
        for(int i =0;i<preorder.length;i++){
            insertIntoBST(preorder[i]);
        }
        return root;
    }
    private void insertIntoBST(int value){
        if(root == null){
            root = new TreeNode(value);
            return;
        }
        var current = root;
        while (true){
            if(current.val > value){
                if(current.left == null){
                    current.left = new TreeNode(value);
                    break;
                }
                current = current.left;
            }else{
                if(current.right == null){
                    current.right = new TreeNode(value);
                    break;
                }
                current = current.right;
            }
        }
    }
}
