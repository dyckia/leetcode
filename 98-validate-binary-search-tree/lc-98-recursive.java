class Solution {
    public boolean isValidBST(TreeNode root) {
        
        if (root == null) return true;
        
        // use null instead of Integer.MAX_VALUE to avoid
        // if value contains MAX_VALUE
        return isValidBST(root, null, null);
    }
    
    // recursively set the lower bound and upper bound while we traverse the tree
    private boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        // root must not be null 
        
        boolean flag = true;
        
        if (lower != null) 
            flag = flag && (root.val > lower);
        
        if (upper != null)
            flag = flag && (root.val < upper);
        
        if (root.left != null) 
            flag = flag && isValidBST(root.left, lower, root.val);
        
        if (root.right != null)
            flag = flag && isValidBST(root.right, root.val, upper);
        
        return flag;
    }
}