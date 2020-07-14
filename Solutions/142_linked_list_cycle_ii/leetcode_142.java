/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // edge case [null]
        if (head == null) return null;
        
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // cycle found
                ListNode begin = head;
                while (begin != slow) {
                    begin = begin.next;
                    slow = slow.next;
                }
                return begin;
            }
        }
        return null;
    }
}