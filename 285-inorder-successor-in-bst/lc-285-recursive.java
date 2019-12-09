class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;

        if (root.val <= p.val) return inorderSuccessor(root.right, p);

        // root.val > p.val, root is a candidate
        // try search in the left subtree to see if we can find a smaller one
        TreeNode smallerNode = inorderSuccessor(root.left, p);
        return (smallerNode == null) ? root : smallerNode;
    }
}

/*
Time: O(H)
H is the height

Space: O(H)
the call stack
*/