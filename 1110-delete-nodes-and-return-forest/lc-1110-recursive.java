class Solution {
    Set<Integer> toDelSet;
    List<TreeNode> res;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        toDelSet = new HashSet<>();
        for (int val : to_delete) {
            toDelSet.add(val);
        }

        res = new LinkedList<>();
        helper(root, true);

        return res;
    }

    // return the node itself if not be deleted, null otherwise
    private TreeNode helper(TreeNode node, boolean isRoot) {
        if (node == null) return null;

        boolean toDelete = toDelSet.contains(node.val);

        if (isRoot && !toDelete) res.add(node);
        
        // if node is to be deleted, its children are root
        node.left = helper(node.left, toDelete);
        node.right = helper(node.right, toDelete);

        return toDelete ? null : node;
    }
}

/*
Time: O(n)

Space: O(n)
*/