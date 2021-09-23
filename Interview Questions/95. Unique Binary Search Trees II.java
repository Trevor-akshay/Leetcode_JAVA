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
    public List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }
    
    private List<TreeNode> helper(int start,int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        
        for(int i = start;i<=end;i++){
            var left = helper(start,i - 1);
            var right = helper(i + 1,end);
            for(var l : left){
                for(var r : right){
                    TreeNode temp = new TreeNode(i);
                    temp.left = l;
                    temp.right = r;
                    res.add(temp);
                }
            }
        }
        
        return res;
    }
}