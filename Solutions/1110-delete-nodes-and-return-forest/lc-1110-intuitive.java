class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDelSet = new HashSet<>();
        addToSet(to_delete, toDelSet);

        List<TreeNode> res = new LinkedList<>();
        postOrder(root, toDelSet, res);

        // check if root needs to be deleted
        if (root != null && toDelSet.contains(root.val)) delNode(root, res);
        else res.add(root);

        return res;
    }

    private void addToSet(int[] to_delete, Set<Integer> toDelSet) {
        for (int val : to_delete) {
            toDelSet.add(val);
        }
        return;
    }

    // post order to find the parent of node to be deleted
    private void postOrder(TreeNode node, Set<Integer> toDelSet, List<TreeNode> res) {
        if (node == null) return;

        postOrder(node.left, toDelSet, res);
        postOrder(node.right, toDelSet, res);

        if (node.left != null && toDelSet.contains(node.left.val)) {
            node.left = delNode(node.left, res);
        }

        if (node.right != null && toDelSet.contains(node.right.val)) {
            node.right = delNode(node.right, res);
        }

        return;
    }

    // return the new node after deletion
    private TreeNode delNode(TreeNode nodeToDel, List<TreeNode> res) {
        // if nodeToDel's children are not null
        // add them in res

        if (nodeToDel.left != null) res.add(nodeToDel.left);
        if (nodeToDel.right != null) res.add(nodeToDel.right);

        return null;
    }
}

/*
Time: O(n)

Space: O(n)
*/