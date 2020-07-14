// a tree is symmetric if its left subtree is a mirror reflection
// of its right subtree

// two trees are a mirror reflection of each other if
// 1. their two roots have the same value
// 2. the right subtree of one tree is a mirror refelction of the left tree of the other

class Solution {
    public boolean isSymmetric(TreeNode root) {
        // needs to check if root is null
        if (root == null) return true;
        
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}

/*
Time: O(n)

Space: O(n)
The number of recursive calls is bound by the height of the tree. 
In the worst case, the tree is linear and the height is in O(n). 
*/