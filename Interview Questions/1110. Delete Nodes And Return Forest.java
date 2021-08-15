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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for(var num : to_delete)
            set.add(num);
        List<TreeNode> forest = new ArrayList<>();
        dfs(root,set,forest);
        if(!set.contains(root.val))
            forest.add(root);
        
        return forest;
    }
    private TreeNode dfs(TreeNode root,Set<Integer> set,List<TreeNode> forest){
        if(root == null)
            return root;
        
        root.left = dfs(root.left,set,forest);
        root.right = dfs(root.right,set,forest);
        
        if(set.contains(root.val)){
            if(root.left != null)
                forest.add(root.left);
            if(root.right != null)
                forest.add(root.right);
            return null;
        }
        return root;
    }
}