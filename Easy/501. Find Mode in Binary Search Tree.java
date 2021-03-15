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
    public int[] findMode(TreeNode root) {
        if(root == null)
            return new int[0];
        Map<Integer,Integer> map  = new HashMap<>();
        //findMode(root,map);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0;i<n;i++){
                var tempRoot = queue.remove();
                 map.put(tempRoot.val,map.getOrDefault(tempRoot.val,0)+1);

                if(tempRoot.left!=null)
                    queue.add(tempRoot.left);
                if(tempRoot.right != null)
                    queue.add(tempRoot.right);

            }

        }
        Map<Integer,Integer> sorted = new LinkedHashMap<>();
        map.entrySet().stream().
                sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed())
                .forEach(value -> sorted.put(value.getKey(),value.getValue()));
        List<Integer> result = new ArrayList<>();
        int compare = 0;
        for(var key : sorted.keySet()){
            if(compare == 0)
                compare = map.get(key);
            else if(map.get(key) < compare)
                break;
            result.add(key);
        }
        int[] array = new int[result.size()];
        for(int i = 0;i<result.size();i++)
            array[i] = result.get(i);

        return array;
    }
}