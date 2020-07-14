/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/

import java.util.HashMap;

class Solution {

    HashMap<Node, Node> visitedNodes = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {

        if (head == null) {
            return head;
        }

        if (this.visitedNodes.containsKey(head)) {
            return this.visitedNodes.get(head);
        }

        Node node = new Node(head.val, null, null);

        this.visitedNodes.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }
}