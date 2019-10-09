/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/* Instead of using recursion in divide and conquer, 
 * which adds extra memory stack, 
 * we can cut & merge the linked list in place.
 */

class Solution {
    public ListNode sortList(ListNode head) {
        // edge case null or only one node
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        
        int length = 0;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        
        for (int step = 1; step < length; step*=2) {
            // d->4->2->1->3
            // p  l  r  c   
            // p->m->c
            
            ListNode prevTail = dummy;
            cur = dummy.next;
            
            while (cur != null) {
                ListNode left = cur;
                ListNode right = split(left, step);
                cur = split(right, step);
                prevTail = merge(prevTail, left, right);
            }
        }
        
        return dummy.next;
    }
    
    // cut the given linked list after step-th Node after the head
    // return the head of the second part 
    private ListNode split(ListNode head, int step) {
        
        if (head == null) return null;
        
        ListNode firTail = head;
        
        for (int i=1; i<step; i++) {
            firTail = firTail.next;
            // return null if the length of first half is less than step 
            if (firTail == null) return null;
        }
        
        ListNode secHead = firTail.next;
        firTail.next = null;
        
        return secHead;
    }
    
    // merge sorted list left and right, and append the combined list to prev
    private ListNode merge(ListNode prevTail, ListNode left, ListNode right) {
        
        while (left != null && right != null) {
            if (left.val <= right.val) {
                prevTail.next = left;
                left = left.next;
            } else {
                prevTail.next = right;
                right = right.next;
            }
            prevTail = prevTail.next;
        }
        
        prevTail.next = left == null ? right : left;
        
        while (prevTail.next != null) {
            prevTail = prevTail.next;
        }
        
        return prevTail;
    }
}