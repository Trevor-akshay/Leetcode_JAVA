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
        List<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return build(0,list.size()-1);
    }
    
    private TreeNode build(int start,int end){
        if(start > end)
            return null;
        int mid = (end + start) >> 1;
        var head = new TreeNode(list.get(mid));
        head.left = build(start,mid-1);
        head.right = build(mid+1,end);
        
        return head;
    }
    
    private void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}