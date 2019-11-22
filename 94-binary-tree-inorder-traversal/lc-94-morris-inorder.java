class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                // find the predecessor of current node
                TreeNode predecessor = getPred(cur);
                if (predecessor.right == null) {
                    predecessor.right = cur;
                    cur = cur.left;
                } else {
                    // predecessor == cur
                    predecessor.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            } else {
                // cur.left == null
                res.add(cur.val);
                cur = cur.right;
            }
        }

        return res;
    }

    private TreeNode getPred(TreeNode cur) {
        TreeNode pred = cur.left;
        while (pred.right != null && pred.right != cur) {
            pred = pred.right;
        }

        return pred;
    }
}