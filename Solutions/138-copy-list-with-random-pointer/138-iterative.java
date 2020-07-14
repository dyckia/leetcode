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

        Node cur = head;
        Node copiedHead = new Node(head.val, null, null);
        Node copiedCur = copiedHead;

        while (cur != null) {
            visitedNodes.put(cur, copiedCur);

            // copy next pointer
            copiedCur.next = getCopiedNode(cur.next);

            // copy random pointer
            copiedCur.random = getCopiedNode(cur.random);

            cur = cur.next;
            copiedCur = copiedCur.next;
        }

        return copiedHead;
    }

    private Node getCopiedNode(Node originalNode) {
        Node copiedNode;
        if (originalNode == null) {
            copiedNode = null;
        } else if (visitedNodes.containsKey(originalNode)) {
            copiedNode = visitedNodes.get(originalNode);
        } else {
            copiedNode = new Node(originalNode.val, null, null);
            visitedNodes.put(originalNode, copiedNode);
        }
        return copiedNode;
    }
}

/*
Time Complexity : O(N) because we make one pass over the original linked list.
Space Complexity: O(N) as we have a dictionary containing mapping from old list 
nodes to new list nodes. Since there are N nodes, we have O(N) space complexity.
*/ 