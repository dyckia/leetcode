/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode head = new ListNode(0);

        while (!stack1.empty() || !stack2.empty()) {
            sum += stack1.empty() ? 0 : stack1.pop();
            sum += stack2.empty() ? 0 : stack2.pop();
            sum += head.val;

            head.val = sum % 10;
            ListNode newHead = new ListNode(sum / 10);
            newHead.next = head;
            head = newHead;
            sum = 0;
        }

        return head.val == 0 ? head.next : head;
    }
}