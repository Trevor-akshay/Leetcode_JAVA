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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            var res = new TreeNode(val);
            res.left = root;
            return res;
         }
        dfs(root,depth,val,1);
        return root;
    }
    
    private void dfs(TreeNode root,int depth,int val,int t){
        if(root == null)
            return;
        if(depth-1 == t){
            var temp = root.left;
            root.left = new TreeNode(val);
            root.left.left =temp;
            temp = root.right;
            root.right = new TreeNode(val);
            root.right.right = temp;
        }
        else{
            dfs(root.left,depth,val,t+1);
            dfs(root.right,depth,val,t+1);
        }
    }
}