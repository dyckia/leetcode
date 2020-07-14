class Solution {
    public TreeNode convertBST(TreeNode root) {
        // since it is a binary search tree
        // right > root > left
        // modify the morris in order traversal order to right -> root -> left (reverse in-order traversal)
        // while keeping track of the accumulative sum
        
        int sum = 0;
        TreeNode cur = root;
        
        while (cur != null) {

            if (cur.right == null) {
                sum += cur.val;
                cur.val = sum;
                cur = cur.left;
            } else {
                // if cur has right subtree
                // find the bottom left most node in its right subtree
                TreeNode successor = cur.right;
                while (successor.left != null && successor.left != cur) {
                    successor = successor.left;
                }

                if (successor.left == null) {
                    // if successor.left == null the node's left to cur as a back pointer
                    // since that node is the last node we're going to visit in its right subtree
                    successor.left = cur;
                    cur = cur.right;
                } else {
                    // if cur's successor points to cur itself
                    // that means we've already visited its right subtree
                    // visit cur node, remove back pointer and go left
                    sum += cur.val;
                    cur.val = sum;
                    successor.left = null;
                    cur = cur.left;
                }
            }

        }

        return root;
    }
}

/*
O(n)
For each node, we visit that node at most twice.

O(1)
Since we manipulate the point to backtrack to its parent node.
*/