class Solution {
    List<Integer> res = new LinkedList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        // root == null?
        if (root == null) return res;
        
        res.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);

        return res;
    }

    private void leftBoundary(TreeNode cur) {
        if (cur == null || isLeaf(cur)) return;
        res.add(cur.val);

        if (cur.left == null && cur.right != null) leftBoundary(cur.right);
        else leftBoundary(cur.left);

        return;
    }


    private void leaves(TreeNode cur) {
        if (cur == null) return;

        if (isLeaf(cur)) res.add(cur.val);

        leaves(cur.left);
        leaves(cur.right);

        return;
    }

    private void rightBoundary(TreeNode cur) {
        if (cur == null || isLeaf(cur)) return;

        if (cur.right == null && cur.left != null) rightBoundary(cur.left);
        else rightBoundary(cur.right);
        // traverse first then add (reverse right boundary)
        res.add(cur.val);

        return;
    }
    
    private boolean isLeaf(TreeNode cur) {
        return (cur.left == null && cur.right == null);
    }
}

/*
Time: O(n)

Space: O(n)
*/