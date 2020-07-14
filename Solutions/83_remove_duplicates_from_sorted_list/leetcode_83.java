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
        // edge case []
        if (head == null) return head;
        
        // case 1-1-1-2-3-3
        // keep searching the linkedlist with cur, if duplicated values found
        // mark the first node's postion
        
        ListNode cur = head;
        ListNode mark = null;
        
        while (cur.next != null) {
            if (cur.val == cur.next.val && mark == null) {
                // found first duplicated value, mark
                mark = cur;
            } else if (cur.val != cur.next.val && mark != null) {
                // found end of duplicated value, change mark's pointer to the first different value
                // and reset mark to null
                mark.next = cur.next;
                mark = null;
            }
            cur = cur.next;
        }
        
        // if mark is not null, it means we still have duplicated nodes
        if (mark != null) mark.next = cur.next;
        
        return head;
    }
}