/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 1 2 3 4 5 6 7 n m=3, n=6
        // b a
        // p c n m=1, n=4
        // t p c n=1
        // bef pointer points to the node before traversal
        // aft pointer points to the node after traversal

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode bef = dummy;
        // move bef pointer to its position
        while (m != 1) {
            bef = bef.next;
            m--;
            n--;
        }

        ListNode prev = bef.next, cur = bef.next.next, next = null;
        ListNode revTail = prev;
        while (n != 1) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            n--;
        }

        bef.next = prev;
        revTail.next = cur;

        return dummy.next;
    }
}