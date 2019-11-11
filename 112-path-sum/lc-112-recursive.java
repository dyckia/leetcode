class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        
        // reached to a leaf
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        
        boolean res = false;
        
        if (root.left != null) {
            res = res || hasPathSum(root.left, sum - root.val);
        }
        
        if (root.right != null) {
            res = res || hasPathSum(root.right, sum - root.val);
        }
        
        return res;
    }
}

/*
Time: O(n)

Space: O(n)
*/