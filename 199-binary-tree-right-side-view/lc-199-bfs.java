class Solution {
    // we can do a breath first traversal, store the last element
    // in each level in the list
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new Queue<>();
        if (root == null) return res;
        queue.offer(root);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode cur = queue.poll();
                // make sure we don't offer null element
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                // last element in the level
                if (i == 1) res.add(cur.val);
            }
        }
        return res;
    }

}

/*
Time: O(n)

Space: O(n)
the size of the last layer is at most 0.5n (complete tree)
*/