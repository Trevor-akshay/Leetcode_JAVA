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
    List<Integer> list = new ArrayList<>();
        if(root == null) 
            return list;
        var current = root;
        while(current != null){
            var prev = current;
            if(current.left == null){
                list.add(current.val);
                current = current.right;
            }else{
                current = current.left;
                while(current.right!=null){
                    current = current.right;
                }
                current.right =new TreeNode(prev.val);
                current.right.right = prev.right;
                current = prev.left;
            }
        }
        return list;
}
}
