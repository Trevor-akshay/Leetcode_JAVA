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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        binaryTreePaths(root,lists,new ArrayList<>());
        for(var tempList : lists){
            StringBuilder s = new StringBuilder();
            for(int i =0;i<tempList.size()-1;i++)
                s.append(tempList.get(i)).append("->");
            s.append(tempList.get(tempList.size()-1));
            list.add(s.toString());
        }
        return list;
    }
    private void binaryTreePaths(TreeNode root,List<List<Integer>> lists,
                                 List<Integer> list) {
        if(root == null)
            return;
        list.add(root.val);
        binaryTreePaths(root.left,lists,list);
        binaryTreePaths(root.right,lists,list);
        if(root.left == null && root.right == null)
            lists.add(new ArrayList<>(list));
        list.remove(list.size()-1);
        }
}
