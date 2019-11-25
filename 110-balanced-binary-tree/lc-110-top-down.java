// for every node in the binary tree
// we check whether the heights of its left subtree and right subtree
// are differed by 1 at most

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 
               && isBalanced(root.left) 
               && isBalanced(root.right);
    }
    
    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        
        int left = getHeight(node.left);
        int right = getHeight(node.right);

        return Math.max(left, right) + 1;
    }
}