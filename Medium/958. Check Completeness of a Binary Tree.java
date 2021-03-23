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
    public boolean isCompleteTree(TreeNode root) {
        return bfs(root);
    }
    
    private boolean bfs(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>(); 
        q.offer(root); 
        boolean nullFound = false;
        while(!q.isEmpty()) { 
            int level = q.size(); 
            for(int i =0; i < level; i++) { 
                TreeNode curr = q.poll(); 
                if(curr == null)
                    nullFound = true;
                else{
                    if(nullFound)
                        return false;
                    q.offer(curr.left); 
                    q.offer(curr.right); 
                }
             
        } 
        }
        return true; 
    } 
    
}