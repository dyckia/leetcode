class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;

        TreeNode left1 = null,
                 right1 = null,
                 left2 = null,
                 right2 = null;
        
        int val1 = 0,
            val2 = 0;

        if (t1 != null) {
            val1 = t1.val;
            left1 = t1.left;
            right1 = t1.right;
        }

        if (t2 != null) {
            val2 = t2.val;
            left2 = t2.left;
            right2 = t2.right;
        }

        TreeNode node = new TreeNode(val1 + val2);
        node.left = mergeTrees(left1, left2);
        node.right = mergeTrees(right1, right2);

        return node;
    }
}