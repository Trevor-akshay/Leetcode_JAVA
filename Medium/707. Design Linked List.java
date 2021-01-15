class MyLinkedList {

   public class node {
        int data;
        node next;
        public node(){}
        public node(int data) {
            this.data = data;
        }}
    
            node head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
         
    
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
            if(head == null) return -1;
        var current = head;
        int position = 0;
        while (current!=null){
            if(position == index)
                return current.data;
            current = current.next;
            position++;
        }
        return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int item) {
        if (head == null) {
            head = new node(item);
            return;
        }
        var current = head;
        head = new node(item);
        head.next = current;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int item) {
         if (head == null) {
            head = new node(item);
            return;
        }
        var current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new node(item);
        current = new node(item);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int position, int item) {
        if(head == null || position == 0){
            var temp = head;
            head = new node(item);
            head.next = temp;
            return;
        }
        var current = head;
        var temp = head;
        int index = 0;
        while (index != position) {
            index++;
            temp = current;
            current = current.next;
        }
        temp.next = new node(item);
        temp.next.next = current;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int position) {
        if(head == null) return;
        if(position == 0) {
            head = head.next;
            return;
        }
        int index = 1;
        var current = head.next;
        var prev = head;
        while (current!=null){
            if(index == position){
                break;
            }
            prev = current;
            current = current.next;
            index++;
        }
        if(current!=null)
            prev.next = current.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */