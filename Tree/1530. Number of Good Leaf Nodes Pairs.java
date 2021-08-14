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
    Map<TreeNode,List<TreeNode>> graph = new HashMap<>();
    Set<TreeNode> leafs = new HashSet<>();
    int count = 0;
    public int countPairs(TreeNode root, int distance) {
        build(root,null);
        for(var leaf : leafs){
            dfs(leaf,distance,new HashSet<>());
        }
        return count / 2;
    }
    
    private void dfs(TreeNode leaf,int d,Set<TreeNode> visited){
        if(d <= 0)
            return;
        visited.add(leaf);
        for(var edge : graph.get(leaf)){
            if(visited.contains(edge))
                continue;
            if(leafs.contains(edge))
                count++;
            dfs(edge,d-1,visited);
        }
    }
    
    private void build(TreeNode root,TreeNode parent){
        if(root == null){
            return;
        }
        build(root.left,root);
        build(root.right,root);
        graph.putIfAbsent(root,new ArrayList<>());
        if(parent != null){
            graph.putIfAbsent(parent,new ArrayList<>());
            graph.get(parent).add(root);
            graph.get(root).add(parent);
        }
        if(root.left == null && root.right == null)
            leafs.add(root);
    }
}
