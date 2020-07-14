class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // two trees are flip equivalent if 
        // the values of two roots are the same
        // their left subtrees and right subtrees are flip equivalent
        
        if (root1 == null && root2 == null) return true;
        // one could be null
        if (root1 == null || root2 == null) return false;
        
        if (root1.val != root2.val) return false;
        
        // case1 left equiv left, right equiv right
        boolean case1 = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        
        // case2 left equiv right, left equiv right
        boolean case2 = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        
        return case1 || case2;
    }
}

/*
Time: O(n)  where n is the smaller number of nodes in tree1 and tree2
Since each value in each tree will be a unique integer. 
Otherwise it would be O(n^2) 

Space: O(n)
*/