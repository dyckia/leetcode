/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        // edge case [null]
        if (head == null)
            return head;

        // first get the length of the list
        ListNode ptr = head;
        int len = 1;
        while (ptr.next != null) {
            ptr = ptr.next;
            len++;
        }

        // attach the tail to the head, making a circle
        ptr.next = head;

        // the new tail is at position of len - (k % len)
        for (int i = len - (k % len); i != 0; i--) {
            ptr = ptr.next;
        }

        // break the circle
        ListNode newHead = ptr.next;
        ptr.next = null;

        return newHead;
    }
}