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

  class Node {
        int val;
        int row;
        public Node (int val, int row) {
            this.val = val;
            this.row = row;
        }
    }
    
    Map<Integer, List<Node>> map = new HashMap<>();
    
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        return normalizeResults();
    }
    
        
    private void dfs(TreeNode node, int col, int row) {

        if (node == null) {
            return;
        }
        min = Math.min(col, min);
        max = Math.max(col, max);
        
        List<Node> list = map.getOrDefault(col, new ArrayList<>());
        list.add(new Node(node.val, row));
        map.put(col, list);
        
        dfs(node.left, col - 1, row + 1);
        dfs(node.right, col + 1, row + 1);
    }
    
    private List<List<Integer>> normalizeResults () {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = min; i<=max; i++) {
            List<Node> temp = map.get(i);
            Collections.sort(temp, new Comparator<Node>() {
                public int compare (Node a, Node b) {
                    return a.row == b.row ? a.val - b.val : a.row-b.row;
                }
            });
            List<Integer> tempVals = new ArrayList<>();
            for (Node n: temp) {
                tempVals.add(n.val);
            }
            result.add(tempVals);
        }
        return result;
    }}