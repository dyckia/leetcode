// since the height of a tree is always greater than or equal to 0
// we use -1 as an flag to indicate if the subtree is not balanced
// use DFS (postorder) to scan the tree
// to avoid checking the height multiple time

class Solution {
    public boolean isBalanced(TreeNode root) {

        return getHeight(root) != -1;
    }
    
    private int getHeight(TreeNode node) {
        if (node == null) return 0;

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        // left, right subtree is unbalanced or cur tree is unbalanced
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}

/*
Time: O(n)
DFS, post-order

Space: O(n)
Recursive call stack.
*/