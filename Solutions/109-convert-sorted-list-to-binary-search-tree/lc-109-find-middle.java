// in order to achieve height balance
// every time we pick the middle element as the root

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        ListNode mid = getMiddle(head);
        TreeNode root = new TreeNode(mid.val);
        
        // mid == head means this is the only one in the list
        if (mid != head) {
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(mid.next);
        }

        return root;
    }
    
    // disconnect the list before the right mid
    // and return the right mid 
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head,
                 fast = head,
                 prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // disconnect only if list is not empty or not one node
        if (prev != null) prev.next = null;

        return slow;
    }
}