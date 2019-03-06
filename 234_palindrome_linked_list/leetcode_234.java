/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // edge case [] or [1]
        if (head == null || head.next == null) {
            return true;
        }

        // edge case [1-2]
        // normal case [1-1-3-1-1] and [1-1-3-3-1-1]
        // use fast slow pointer to find the node before the middle node
        // and cut the list in half
        ListNode mid = findMid(head);
        ListNode secHead = mid.next;
        mid.next = null;

        // reverse the second half
        secHead = reverse(secHead);

        // compare the first half with the second half
        // the length of first half is always less than or equal to second half
        ListNode firPtr = head, secPtr = secHead;
        while (firPtr != null) {
            if (firPtr.val != secPtr.val) {
                return false;
            }
            firPtr = firPtr.next;
            secPtr = secPtr.next;
        }
        return true;
    }

    private ListNode findMid(ListNode head) {
        // return the last node in the first half
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head, pre = null, nex;
        while (cur != null) {
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }
}