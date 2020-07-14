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
    public Node flatten(Node head) {
        flattenedTail(head);
        return head;
    }
    
    //flatten a linked list and return its tail
    private Node flattenedTail(Node head) {
        
        Node cur = head;
        Node tail = head;
        while(cur != null) {
            if (cur.child != null) {
                Node oldNext = cur.next;
                
                //change cur's next pointer
                cur.next = cur.child;
                cur.next.prev = cur;
                cur.child = null;
                
                //change flattenedTail's next pointer
                tail = flattenedTail(cur.next);
                tail.next = oldNext;
                if (oldNext != null) oldNext.prev = tail;

                cur = oldNext;
            } else {
                tail = cur;
                cur = cur.next;
            }
        }
        
        return tail;
    }
}