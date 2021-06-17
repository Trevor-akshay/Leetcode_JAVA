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
    public TreeNode increasingBST(TreeNode root) {
        TreeNode newRoot = new TreeNode();  
        List<Integer> list = new ArrayList<>();
        increasingBST(root,list);
        var result = newRoot;
        for(var item : list){
            newRoot.right = new TreeNode(item);
            newRoot = newRoot.right;
        }
        return result.right;
    }

    private void increasingBST(TreeNode root,List<Integer> list) {
        if(root == null)
            return;
        increasingBST(root.left,list);
        list.add(root.val);
        increasingBST(root.right,list);
    }
}