class Solution {
    // find the node
    // change the node's value to its left node's value or rights'
    // recursively do this until root is a leaf
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) {
            // node to be deleted is in the left subtree
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            // root should be deleted
            // root is a leaf
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left != null) {
                int newVal = findPredecessor(root.left);
                root.val = newVal;
                root.left = deleteNode(root.left, newVal);
            } else {
                // root.right != null
                int newVal = findSuccessor(root.right);
                root.val = newVal;
                root.right = deleteNode(root.right, newVal);
            }
        }
        return root;
    }

    private int findPredecessor(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        
        return root.val;
    }

    private int findSuccessor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }

        return root.val;
    }
}