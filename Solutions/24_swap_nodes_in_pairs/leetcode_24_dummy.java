/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            prev = swap(prev);
        }

        return dummy.next;
    }

    private ListNode swap(ListNode prev) {

        // sequence: prev-cur-next-nnext
        ListNode cur = prev.next;
        ListNode nnext = cur.next.next;

        prev.next = cur.next;
        cur.next.next = cur;
        cur.next = nnext;

        return cur;
    }
}