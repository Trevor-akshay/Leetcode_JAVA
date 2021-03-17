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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        rightSideView(root,list);
        return list;
    }

    private void rightSideView(TreeNode root,List<Integer> list) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            int temp = 0;
            for(int i = 0;i<n;i++){
                var tempRoot = q.poll();
                temp = tempRoot.val;
                if(tempRoot.left != null)
                    q.offer(tempRoot.left);
                if(tempRoot.right != null)
                    q.offer(tempRoot.right);
            }
            list.add(temp);
    }
    }
}
