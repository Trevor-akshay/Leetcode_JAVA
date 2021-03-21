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
    public List<Integer> largestValues(TreeNode root) {
        if(root == null)
            return list;
        bfs(root);
        
        return list;
    }
    
    private void bfs(TreeNode root){
        Queue<TreeNode> q  = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            int value = Integer.MIN_VALUE;
            for(int i = 0;i<n;i++){
                var t = q.remove();
                if(value < t.val)
                    value = t.val;
                if(t.left != null)
                    q.offer(t.left);
                if(t.right != null)
                    q.offer(t.right);
            }
            list.add(value);
            
        }
    }
}