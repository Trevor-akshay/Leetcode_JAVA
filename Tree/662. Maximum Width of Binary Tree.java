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
    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        Map<TreeNode,Integer> map = new HashMap<>();
        q.offer(root);
        map.put(root,1);
        while(!q.isEmpty()){
            int n = q.size();
            int left = 0;
            int right = 0;
            for(int i = 0;i<n;i++){
                var poll = q.poll();
                left = i == 0 ? map.get(poll) : left;
                right = i == n-1 ? map.get(poll) : right;
                
                if(poll.left != null){
                    q.offer(poll.left);
                    map.put(poll.left,map.get(poll) * 2);
                }
                if(poll.right != null){
                    q.offer(poll.right);
                    map.put(poll.right,map.get(poll) * 2 + 1);
                }
            }
            max = Math.max(max,right - left + 1);
        }
        return max;
    }
}