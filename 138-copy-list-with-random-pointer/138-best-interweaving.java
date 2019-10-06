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
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // interweave the old list and new list based on next pointer
        Node cur = head;
        while (cur != null) {
            cur.next = new Node(cur.val, cur.next, null);
            cur = cur.next.next;
        }

        // assign random pointer based on old list node
        cur = head;
        while (cur != null) {
            // if random points to null, null does not have a next pointer
            if (cur.random == null) {
                cur.next.random = null;
            } else {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // unweave the old list and new list
        cur = head;
        Node copiedHead = head.next;
        Node copiedCur = copiedHead;
        while (copiedCur.next != null) {
            cur.next = copiedCur.next;
            cur = cur.next;
            copiedCur.next = cur.next;
            copiedCur = copiedCur.next;
        }

        cur.next = null;

        return copiedHead;
    }
}