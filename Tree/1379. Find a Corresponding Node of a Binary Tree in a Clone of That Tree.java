/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode node = new TreeNode();
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return dfs(original,cloned,target.val);
        
        
    }
    
    private TreeNode dfs(TreeNode root,TreeNode rootCloned,int val){
        if(root == null)
            return null;
        if(root.val == val){
            node = rootCloned;
            //return node;
        }
        else{
            dfs(root.left,rootCloned.left,val) ;
            dfs(root.right,rootCloned.right,val);
            }
        return node;
        }
}