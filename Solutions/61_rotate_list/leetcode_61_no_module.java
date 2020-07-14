/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // 1-2-3-4-5-6-n
        // n k=2
        // n o define two pointers, newTail and oldTail, distance between two nodes is k
        // n o when oldTail reaches the end, the newTail pointer is exactly at the
        // cut-off point

        // edge case [null]
        if (head == null)
            return head;

        // find the new tail
        ListNode oldTail = head, newTail = head;
        for (int i = k; i != 0; i--) {
            if (oldTail.next == null) {
                oldTail = head;
            } else {
                oldTail = oldTail.next;
            }
        }

        // edge case oldTail.next == null -> ok
        // edge case oldTail == head -> return original list
        // edge case 1-n -> return original list
        if (oldTail == head)
            return head;

        // move oldTail and newTail simultaneously
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            newTail = newTail.next;
        }

        // attach the old tail to the old head, new tail to null
        ListNode newHead = newTail.next;
        oldTail.next = head;
        newTail.next = null;

        return newHead;
    }
}