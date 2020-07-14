class Solution {
    private int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        // since it is a binary search tree
        // right > root > left
        // modify the dfs traverse order to right -> root -> left (reverse in-order traversal)
        // while keeping track of the accumulative sum
        
        if (root == null) return root;
        
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}

/*
Time: O(n)

Space: O(n)
*/