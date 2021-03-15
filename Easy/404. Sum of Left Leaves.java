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
    public int sumOfLeftLeaves(TreeNode root) {
       int result = 0;
        if (null == root || (null == root.left && null == root.right)) 
        return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (null != node.left && null == node.left.left && null == node.left.right) {
            result += node.left.val;
        }
        if (null != node.left) {
            queue.offer(node.left);
        }
        if (null != node.right) {
        queue.offer(node.right);
        }
    }
        return result;
    }
}