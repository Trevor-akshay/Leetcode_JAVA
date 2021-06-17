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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(list,root);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<list.size();i++){
            if(map.containsKey(k - list.get(i)))
                return true;
            map.put(list.get(i),i);
        }
        return false;
    }
    
    private void dfs(List<Integer> list,TreeNode node){
        if(node == null)
            return;
        list.add(node.val);
        dfs(list,node.left);
        dfs(list,node.right);
    }
}