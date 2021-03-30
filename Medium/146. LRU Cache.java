
class LRUCache {
    
    Node head = new Node();
    Node tail = new Node();
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            add(node);
            return node.val;
        }
        return -1; 
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) { 
            Node node = map.get(key);
            remove(node);
            node.val = value; // update node
            add(node);
        } else {
            if (map.size() == capacity) { // reach to capacity
                map.remove(tail.prev.key); // remove the oldest node from map and cache
                remove(tail.prev);
            } 
        
            Node new_node = new Node();
            new_node.key = key;
            new_node.val = value;
            
            map.put(key, new_node); // add new node to map
            add(new_node); // add new node to cache
        }
    }
    
    public void add(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    public void remove(Node node) {
        Node next_node = node.next;
        Node prev_node = node.prev;
        
        prev_node.next = next_node;
        next_node.prev = prev_node;
    }
    
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */