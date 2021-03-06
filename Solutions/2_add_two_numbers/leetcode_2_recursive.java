/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return resAddTwo(l1, l2, 0);
    }

    public ListNode resAddTwo(ListNode l1, ListNode l2, int carry) {

        // base case, l1==null, l2==null, carry==0
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        if (l1 != null) {
            carry += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            carry += l2.val;
            l2 = l2.next;
        }

        ListNode cur = new ListNode(carry % 10);
        cur.next = resAddTwo(l1, l2, carry / 10);

        return cur;
    }
}