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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if(root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            double sum = 0;
            for(int i = 0;i<n;i++){
                var tempRoot = queue.remove();
                if(tempRoot.left != null)
                    queue.add(tempRoot.left);
                if(tempRoot.right != null)
                    queue.add(tempRoot.right);
                sum+=tempRoot.val;
            }
            list.add(sum/n);
        }
        return list;
    }
}