// place the new node to the child position of current leaf

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode cur = root;
        // if cur.val == val, that means we've inserted val into the tree
        while (cur.val != val) {
            if (cur.val > val) {
                // go left
                if (cur.left == null) cur.left = new TreeNode(val);
                cur = cur.left;
            } else {
                // go right
                if (cur.right == null) cur.right = new TreeNode(val);
                cur = cur.right;
            }
        }

        return root;
    }
}

/*
Time: O(H)

Space: O(1)
Recursive call stack
*/