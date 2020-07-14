// in order to achieve height balance
// every time we pick the middle element as the root

class Solution {
    ListNode cur;

    public TreeNode sortedListToBST(ListNode head) {
        int size = getSize(head);
        cur = head;
        return helper(0, size - 1);
    }
    
    private int getSize(ListNode head) {
        int s = 0;
        while (head != null) {
            s++;
            head = head.next;
        }
        return s;
    }

    // the inorder traversal order is same as the order in the LinkedList
    // thus always use cur value for constructing current node
    // left and right is just an indicator to check wheter or not we should terminate the recursive call
    private TreeNode helper(int left, int right) {
        if (right < left) return null;
        
        // left mid index
        int mid = left + (right - left) / 2;

        TreeNode leftNode = helper(left, mid - 1);
        TreeNode root = new TreeNode(cur.val);
        root.left = leftNode;
        cur = cur.next;
        root.right = helper(mid + 1, right);

        return root;
    }
}