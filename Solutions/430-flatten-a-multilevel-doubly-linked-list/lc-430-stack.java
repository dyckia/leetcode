/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    private Stack<Node> remainNodes = new Stack<>();
    
    public Node flatten(Node head) {
        
        Node cur = head;
        Node tail = head;
        
        while (cur != null) {
            if (cur.child != null) {
                if (cur.next != null) {
                    remainNodes.push(cur.next);
                }
                cur.next = cur.child;
                cur.next.prev = cur;
                cur.child = null;
            }
            tail = cur;
            cur = cur.next;
        }
        
        if (!remainNodes.empty()) {
            Node nextNode = flatten(remainNodes.pop());
            tail.next = nextNode;
            nextNode.prev = tail;
        }
        
        return head;
    }
}