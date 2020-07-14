// in order to achieve height balance
// every time we pick the middle element as the root

class Solution {
    List<Integer> list;

    public TreeNode sortedListToBST(ListNode head) {
        list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return helper(list, 0, list.size() - 1);
    }
    

    private TreeNode helper(List<Integer> list, int left, int right) {
        if (right < left) return null;

        // left mid index
        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(list.get(mid));
        
        root.left = helper(list, left, mid - 1);
        root.right = helper(list, mid + 1, right);

        return root;
    }
}