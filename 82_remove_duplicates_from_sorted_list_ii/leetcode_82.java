/**
 * Definition for singly-linked list. 
 * public class ListNode { 
 *     int val; 
 *     ListNode next; 
 *     ListNode(int x) { val = x; } 
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // use two pointers to mark the position of duplicated nodes
        // fir marks the node before the first occurence of duplicated node
        // sec marks the last occurence of duplicated node

        // edge case [null]
        if (head == null)
            return head;

        ListNode dummy = new ListNode(-1), fir, sec;
        dummy.next = head;
        fir = dummy;

        while (fir.next != null && fir.next.next != null) {
            // values of next two adjacent nodes are the same, starting searching till
            // different value
            if (fir.next.val == fir.next.next.val) {
                sec = fir.next.next;
                while (sec.next != null && fir.next.val == sec.next.val) {
                    sec = sec.next;
                }
                // last duplicated node is found, delete all the duplicated nodes
                fir.next = sec.next;
            } else {
                // values of next two adjacent nodes are different, move f by one node
                fir = fir.next;
            }
        }
        return dummy.next;
    }
}