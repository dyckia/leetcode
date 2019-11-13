class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // two trees are the same if
        // 1. their root values are the same
        // 2. their left and right subtrees are the same respectively
        
        if (p == null && q == null) return true;
        
        if (p == null || q == null) return false;
        
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

/*
Time: O(n)

Space: O(n)
*/