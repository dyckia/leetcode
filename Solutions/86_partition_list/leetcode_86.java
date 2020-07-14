/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLess = new ListNode(-1), ptrLess = dummyLess;
        dummyLess.next = head;
        ListNode dummyGreater = new ListNode(-1), ptrGreater = dummyGreater;

        while (ptrLess.next != null) {
            if (ptrLess.next.val >= x) {
                ptrGreater.next = ptrLess.next;
                ptrLess.next = ptrLess.next.next;
                ptrGreater = ptrGreater.next;
            } else {
                ptrLess = ptrLess.next;
            }
        }

        ptrGreater.next = null;
        ptrLess.next = dummyGreater.next;

        return dummyLess.next;
    }
}