// for each node in s, assume it as the root and compare it with t

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // both trees are non-empty
        if (s == null) return false;
        
        return equal(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean equal(TreeNode x, TreeNode y) {
        if (x == null && y == null) return true;
        
        if (x == null || y == null) return false;
        
        return x.val == y.val && equal(x.left, y.left) && equal(x.right, y.right);
    }
}

/*
Time: O(s * t)
for each node in tree s, we will compare at most t times

Space: O(t)
call stack for comparing the equality
*/