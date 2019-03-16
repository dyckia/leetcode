/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    ListNode left;
    boolean stopSwap = false;

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // move left pointer to the beginning node of reversal
        left = head;
        ListNode right = head;

        while (m != 1) {
            left = left.next;
            right = right.next;
            m--;
            n--;
        }

        recurSwap(right, n);

        return head;
    }

    private void recurSwap(ListNode right, int n) {
        // using recursive call to backtrack right node
        if (n != 1) {
            // move right pointer to the ending node of reversal
            recurSwap(right.next, n - 1);
        }

        if (!stopSwap) {
            int temp = right.val;
            right.val = left.val;
            left.val = temp;
        }
        left = left.next;

        if (left == right || right.next == left) {
            stopSwap = true;
        }
    }
}