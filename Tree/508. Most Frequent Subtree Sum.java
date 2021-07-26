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
    Map<Integer,Integer> freq = new HashMap<>();
    int maxCount = 0;
    int n = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int[] result = new int[n];
        int index = 0;
        for(var f : freq.keySet()){
            if(freq.get(f) == maxCount)
                result[index++] = f;
        }
        return result;
        
    }
    
    private int dfs(TreeNode root){
        if(root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int score = left + right + root.val;
        freq.merge(score,1,Integer::sum);
        if(maxCount < freq.get(score)){
            maxCount = freq.get(score);
            n = 1;
        }else if(maxCount == freq.get(score))
            n++;
        
        return score;
    }
}