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
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur=head, insertPos, temp;
        
        while(head != null && cur.next != null) {
            if (cur.val < cur.next.val) {
                cur = cur.next;
            } else {
                temp = cur.next;
                cur.next = cur.next.next;
                insertPos = dummy;
                while (temp.val > insertPos.next.val) {
                    insertPos = insertPos.next;
                }
                temp.next = insertPos.next;
                insertPos.next = temp;
            }
        }
        
        return dummy.next;
	}
}