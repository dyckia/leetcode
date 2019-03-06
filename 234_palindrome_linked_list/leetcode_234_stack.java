/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {

        // 1-2-2-3-2-2-1
        // we can use a stack to store the values while we traverse the list
        // values in the stack will be in the reverse order of the list
        ListNode cur = head;

        Stack<Integer> st = new Stack<>();
        while (cur != null) {
            st.push(cur.val);
            cur = cur.next;
        }

        // we then travese the list again
        // if the value on top of the stack is same as the cur node, pop()
        // if not, return false
        cur = head;
        while (cur != null) {
            if (st.pop() != cur.val) {
                return false;
            } else {
                cur = cur.next;
            }
        }

        return true;
    }
}