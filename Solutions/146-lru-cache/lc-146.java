class LRUCache {
    // use HaspMap to achieve get in O(1)
    // use doubly linked list to achieve random insertion and removal in O(1)

    // dummy head and tail for the doubly linked list
    DNode head;
    DNode tail;
    HashMap<Integer, DNode> map;
    int size;
    int capacity;

    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            // update head and return value
            DNode node = map.get(key);
            removeNode(node);
            insertAtHead(node);
            return node.val;
        }
        // otherwise return -1
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DNode node = map.get(key);
            // update node value
            node.val = value;
            removeNode(node);
            insertAtHead(node);
        } else {
            DNode node = new DNode();
            node.val = value;
            node.key = key;
            map.put(key, node);
            insertAtHead(node);
            if (this.size != capacity) {
                size++;
            } else {
                // evicts tail
                DNode tail = this.tail.prev;
                map.remove(tail.key);
                removeNode(tail);
            }
        }
    }

    // doubly linked list node
    class DNode {
        int val;
        int key; // in order to remove the node in the map
        DNode prev;
        DNode next;
    }

    // remove a given node from the doubly linked list
    private void removeNode(DNode node) {
        DNode prevNode = node.prev;
        DNode nextNode = node.next;
        node.prev = null;
        node.next = null;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // insert a given node right after the dummy head
    private void insertAtHead(DNode node) {
        // Todo check by removing this
        DNode oldHead = this.head.next;
        this.head.next = node;
        node.prev = this.head;
        node.next = oldHead;
        oldHead.prev = node;
    }


}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */