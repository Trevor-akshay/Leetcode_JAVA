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
    TreeNode head = null;
    public TreeNode trimBST(TreeNode root, int low, int high) {
        dfs(root,low,high);
        
        return head;
    }
    private void dfs(TreeNode root,int low,int high){
        if(root == null)
            return;
        if(root.val <= high && root.val >= low)
            insert(root.val);
        dfs(root.left,low,high);
        dfs(root.right,low,high);
    }
    
    private void insert(int val){
        if(head == null){
            head = new TreeNode(val);
            return;
        }
        var cur = head;
        while(true){
            if(cur.val < val){        
                if(cur.right == null){
                    cur.right = new TreeNode(val);
                    break;
                }
                cur = cur.right;
               
            }else{
                if(cur.left == null){
                    cur.left = new TreeNode(val);
                    break;
                }
                cur = cur.left;
            }
        }
    }
}