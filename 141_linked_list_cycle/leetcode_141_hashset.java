/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // we can create a set to store the nodes we've visited
        // space complexity is O(n) since we need a HashSet of size n
        HashSet<ListNode> visitedNodes = new HashSet<ListNode>();

        ListNode cur = head;
        while (cur != null) {
            if (visitedNodes.contains(cur)) {
                return true;
            } else {
                visitedNodes.add(cur);
                cur = cur.next;
            }
        }

        return false;
    }
}