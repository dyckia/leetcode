class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;

        if (root.val <= p.val) return inorderSuccessor(root.right, p);

        // root.val > p.val
        TreeNode smallerNode = inorderSuccessor(root.left, p);
        return (smallerNode == null) ? root : smallerNode;
    }
}