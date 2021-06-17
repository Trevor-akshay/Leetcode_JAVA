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
    public boolean isCousins(TreeNode root, int x, int y) {
       return bfs(root,x,y);
    }
    private boolean bfs(TreeNode root,int x,int y){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            boolean found = false;
            for (int i = 0; i < n; i++) {
                boolean flag = false;
                var tempRoot = queue.remove();
                if (tempRoot.left != null){
                    if(tempRoot.left.val == x || tempRoot.left.val == y){
                        if(found)
                            return true;
                        flag = true;
                        found = true;
                    }
                    queue.add(tempRoot.left);
                }

                if (tempRoot.right != null){
                    if(tempRoot.right.val == x || tempRoot.right.val == y){
                        if(flag)
                            return false;
                        if(found)
                            return true;
                        found = true;
                    }
                    queue.add(tempRoot.right);
                }

            }
        }
        return false;
    }
}