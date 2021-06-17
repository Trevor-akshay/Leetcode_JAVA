/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
     if (node == null) return null;

    Node newNode = new Node(node.val, new ArrayList<>());
    HashMap<Node, Node> map = new HashMap();
    map.put(node, newNode);

    Queue<Node> queue = new ArrayDeque();
    queue.add(node);
        
    while (!queue.isEmpty()) {
        Node polledOrigNode = queue.poll();

        for (Node origNeighbor : polledOrigNode.neighbors) {
           if (!map.containsKey(origNeighbor)) {
                Node newNeighborNode = new Node(origNeighbor.val, new ArrayList<>());
                map.put(origNeighbor, newNeighborNode);
                queue.add(origNeighbor);
            }
           map.get(polledOrigNode).neighbors.add(map.get(origNeighbor));
        }
    }

    return newNode;
    }
}