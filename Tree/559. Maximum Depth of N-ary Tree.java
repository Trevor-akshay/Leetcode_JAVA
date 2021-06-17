/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
		if (root == null) {
			return 0; 
		}
		return breadthFirstSearchAlgorithm(root);
	}

	private int breadthFirstSearchAlgorithm (Node root) {

		Queue<Node> queue = new LinkedList<Node>();
		int level = 0; 
    	queue.add(root);
		while (!queue.isEmpty()) {
			int queueSize = queue.size(); 
			for (int i = 0; i < queueSize; i++) {
				root = queue.poll();
                for (Node node : root.children) {
                    queue.add(node);
				}
			}
			level++; 
		}
		return level;
        
    }
}