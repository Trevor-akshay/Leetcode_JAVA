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
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        bfs(root); 
        
        return sum;
    }
    
    private void bfs(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0;i<n;i++){
                var temp = q.poll();
                if(temp.left != null){
                    q.offer(temp.left);
                    if(temp.val % 2 == 0){
                        if(temp.left.left != null)
                            sum+=temp.left.left.val;
                        if(temp.left.right != null)
                            sum+=temp.left.right.val;
                        
                    }
                }
                if(temp.right != null){
                    q.offer(temp.right);
                    if(temp.val % 2 == 0){
                        if(temp.right.left != null)
                            sum+=temp.right.left.val;
                        if(temp.right.right != null)
                            sum+=temp.right.right.val;
                    }
                }
            }
        }
    }
}