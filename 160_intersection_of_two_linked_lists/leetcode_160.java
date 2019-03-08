/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // assume two lists are intersected
        // to get the pointers meet at the intersectionNode
        // we need to have these two pointers travel the same length
        // we can do this by reseting the pointer to the head of the other node
        // if the pointer reaches the end of current list
        // in this way, both pointers travels two first unique halves and one common
        // last half

        // edge case, if one of the lists is empty, return null
        if (headA == null || headB == null) {
            return null;
        }

        ListNode ptrA = headA, ptrB = headB;
        int counter = 0;

        // counter = 3 means ptr has traversed both list once
        while (counter < 3) {
            if (ptrA == ptrB) {
                return ptrA;
            }

            ptrA = ptrA.next;
            ptrB = ptrB.next;

            if (ptrA == null) {
                ptrA = headB;
                counter += 1;
            }
            if (ptrB == null) {
                ptrB = headA;
                counter += 1;
            }
        }

        return null;
    }
}