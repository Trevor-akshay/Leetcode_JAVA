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
    int sum = Integer.MIN_VALUE;
    int level = 0;
    public int maxLevelSum(TreeNode root) {
        bfs(root);
        
        return level;
    }
    
    private void bfs(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int index = 1;

        
        while(!q.isEmpty()){
            int n = q.size();
            int tempSum = 0;
            for(int i = 0;i<n;i++){
                var tempRoot = q.remove();
                if(tempRoot.left != null)
                    q.offer(tempRoot.left);
                if(tempRoot.right != null)
                    q.offer(tempRoot.right);
                tempSum += tempRoot.val;
            }
            if(sum < tempSum){
                sum = tempSum;
                level = index;
            }
            index++;
        }
    }
}