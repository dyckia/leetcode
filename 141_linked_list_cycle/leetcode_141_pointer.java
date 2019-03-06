/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // we create two pointers, the slow pointer moves one node each time
        // while the fast pointer moves two nodes each time
        // if there is a circle in the linked list, the fast pointer will eventually
        // meet the slow pointer
        // imagine a circle track and two runners

        // handle edge case [] or [1]
        if (head == null || head.next == null)
            return false;

        ListNode slowPtr = head, fastPtr = head.next;
        while (fastPtr.next != null && fastPtr.next.next != null) {
            if (fastPtr == slowPtr) {
                return true;
            } else {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
            }
        }

        return false;
    }
}