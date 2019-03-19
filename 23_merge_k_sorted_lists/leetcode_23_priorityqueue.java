/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // edge case []
        if (lists.length == 0) return null;
        
        ListNode dummy = new ListNode(-1), cur=dummy;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val-n2.val;
            }
        });

        for (ListNode head: lists) {
            if (head != null) queue.add(head);
        }

        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (node.next != null) queue.add(node.next);
            cur.next = node;
            cur = cur.next;
        }

        return dummy.next;
    }
}