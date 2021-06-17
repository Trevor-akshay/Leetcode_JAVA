/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        if(root == null)
            return s.toString();
        helper(root,s);
        return s.toString();
    }
    
    private void helper(TreeNode root,StringBuilder s){
        if(root == null){
            s.append("|").append(",");
            return;
        }
        s.append(root.val).append(",");
        helper(root.left,s);
        helper(root.right,s);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0)
            return null;
        List<String> list = Arrays.asList(data.split(","));
        
        return helper(list);
        }
    
    private TreeNode helper(List<String> list){
        if(list.get(index).equals("|")){
            index++;
            return null;
        }
        int val = Integer.parseInt(list.get(index));
        var root = new TreeNode(val);
        index++;
        root.left = helper(list);
        root.right =helper(list);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;