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
    public String tree2str(TreeNode t) {
        if(t == null)
            return "";
        String s = t.val+"";
        boolean hasLeft = false;
        if(t.left != null){
            hasLeft = true;
            s += "("+tree2str(t.left)+")";
        }
        if(t.right != null){
            if(hasLeft){
                s+="("+tree2str(t.right)+")";
            }
            else{
                s+="()"+"("+tree2str(t.right)+")";
            }
        }
        return s;
    }
}