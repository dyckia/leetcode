/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // we can create two pointers
        // the distrance between these two pointers is n-1
        // thus when the fast pointer reaches the end
        // the slow pointer is just before the node to be deleted
        
        // 1-2-3-4-5-n
        // |   |
        //     |   |
        
        ListNode slow=head, fast=head;
        
        for (int i=n; i>0; i--) {
            fast = fast.next;
        }
        
        // edge case, n = listsize, remove head
        if (fast == null) return head.next;
        
        while (fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        
        return head;
    }
}