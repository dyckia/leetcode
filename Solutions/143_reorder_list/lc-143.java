/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public void reorderList(ListNode head) {
        // cut the linked list into two halves
        ListNode secHead = splitInHalf(head);

        // reverse the second half
        secHead = reverseList(secHead);

        // interweave the two lists
        interweave(head, secHead);
    }

    private ListNode splitInHalf(ListNode head) {
        if (head == null)
            return head;
        if (head.next == null)
            return head.next;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secHead = slow.next;
        slow.next = null;

        // fast becomes the second half's head
        return secHead;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    private void interweave(ListNode ptr1, ListNode ptr2) {
        // the first half is always longer than or equal to the second half
        ListNode head = ptr1;
        while (ptr2 != null) {
            ListNode temp = ptr1.next;
            ptr1.next = ptr2;
            ptr2 = ptr2.next;
            ptr1.next.next = temp;
            ptr1 = temp;
        }
    }
}