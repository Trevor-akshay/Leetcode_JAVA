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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        if(n == 1){
            res.add(new TreeNode(0));
            return res;
        }
        for(int i = 1;i<n;i+=2){
            var leftTree = allPossibleFBT(i);
            var rightTree = allPossibleFBT(n - i - 1);
            for(var left : leftTree){
                for(var right : rightTree){
                    TreeNode temp = new TreeNode(0);
                    temp.left = left;
                    temp.right = right;
                    res.add(temp);
                }
            }
        }
        return res;
    }
}