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
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list,root);
        int min = Integer.MAX_VALUE;
        for(int i = 1;i<list.size();i++){
            if(list.get(i) - list.get(i-1) < min)
                min = list.get(i) - list.get(i-1);
        }
        return min;
    }
    private void dfs(List<Integer> list,TreeNode root){
        if(root == null)
            return;
        dfs(list,root.left);
        list.add(root.val);
        dfs(list,root.right);

    }
}