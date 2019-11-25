// inorder traversal outputs the values in BST in ascending order

class Solution {

    int ans;
    int count;

    public int kthSmallest(TreeNode root, int k) {
        ans = -1;
        count = k;
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        
        inorder(root.left);
        count--;
        if (count == 0) ans = root.val;
        inorder(root.right);
        return;
    }
}