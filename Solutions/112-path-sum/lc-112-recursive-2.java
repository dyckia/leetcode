class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        
        sum -= root.val;

        // reached to a leaf
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}

/*
Time: O(n)

Space: O(n)
*/