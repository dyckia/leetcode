/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        
        ListNode sortedHead = new ListNode(-1);
        sortedHead.next = null;
        ListNode input = head;         
        
        while (input != null) {
            ListNode insertPos = sortedHead;
            while (insertPos.next != null && input.val > insertPos.next.val) {
                insertPos = insertPos.next;
            }
            ListNode temp = insertPos.next;
            insertPos.next = input;
            input = input.next;
            insertPos.next.next = temp;
        }
        
        return sortedHead.next;
    }
}