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
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return lists;
        dfs(root,new ArrayList<>(),targetSum);
        
        return lists;   
    }
    
    private void dfs(TreeNode root,
                     List<Integer> list,int sum){
        if(root == null)
            return;
        list.add(root.val);
        sum -= root.val;
        dfs(root.left,list,sum);
        dfs(root.right,list,sum);
        if(root.left == null && root.right == null && sum == 0)
            lists.add(new ArrayList<>(list));
        
        list.remove(list.size()-1);
    }
}