class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);

        return res;
    }

    // add nodes on the left boundary to res, except for the leaf
    private void addLeftBoundary(TreeNode root, List<Integer> res) {
        if (root == null || isLeaf(root)) return;

        // root is not a leaf, root must be added here
        res.add(root.val);
        // if root doesn't have left, left boundary is root itself
        if (root.left == null) return;

        TreeNode cur = root.left;
        while (!isLeaf(cur)) {
            res.add(cur.val);
            cur = (cur.left != null) ? cur.left : cur.right;
        }

        return;
    }

    private void addLeaves(TreeNode root, List<Integer> res) {
        if (root == null) return;

        addLeaves(root.left, res);
        if (isLeaf(root)) res.add(root.val);
        addLeaves(root.right, res);

        return;
    }

    private void addRightBoundary(TreeNode root, List<Integer> res) {
        if (root == null || root.right == null) return;

        Stack<Integer> stack = new Stack<>();
        // we don't need to add root val
        TreeNode cur = root.right;
        while (!isLeaf(cur)) {
            stack.push(cur.val);
            cur = (cur.right != null) ? cur.right : cur.left;
        }

        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }

        return;
    }

    private boolean isLeaf(TreeNode node) {
        return (node.left == null && node.right == null);
    }
}