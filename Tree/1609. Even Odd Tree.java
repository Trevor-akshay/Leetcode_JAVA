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
    public boolean isEvenOddTree(TreeNode root) {
        return bfs(root);
    }
    private boolean bfs(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int index = 0;
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int n = q.size();
            for(int i = 0;i<n;i++){
                var temp = q.remove();
                if(index %2 == 0){
                    if(temp.val % 2 == 0)
                        return false;
                    if(list.isEmpty()){}
                    else{
                        if(list.get(list.size()-1) >= temp.val)
                            return false;
                    }
                }else{
                    if(temp.val % 2 != 0)
                        return false;
                    if(list.isEmpty()){}
                    else{
                        if(list.get(list.size()-1) <= temp.val)
                            return false;}
                }
                list.add(temp.val);
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
            index++;
        }
        return true;
    }
}