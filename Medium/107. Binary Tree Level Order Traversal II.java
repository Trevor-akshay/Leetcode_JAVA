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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
         List<List<Integer>> list = new ArrayList<>();
       if(root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i<n;i++){
                var tempRoot = queue.peek();
                temp.add(queue.remove().val);
                if(tempRoot.left!= null)
                    queue.add(tempRoot.left);
                if(tempRoot.right != null)
                    queue.add(tempRoot.right);
            }
            list.add(temp);
        }
        Collections.reverse(list);
        return list;
    }
}