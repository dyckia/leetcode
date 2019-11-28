/* 
use preorder to find the root
- the root of current tree is the first element of preorder
- the root of left subtree is the second element of preorder
- the root of right subtree is the index of first element + number of left subtree nodes + 1

use inorder to find the number of nodes in left subtree

            1
           / \
          2   3
         / \   \
        4   5   6

preorder: 1 (2 4 5) [3 6]
inorder: (4 2 5) 1 [3 6]

() left
[] right
*/

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode buildTree (int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        // no nodes to be constructed in current scope
        if (inStart > inEnd) return null;

        // root must be the first element in preorder
        TreeNode root = new TreeNode(preorder[preStart]);
        
        // current root's index in inorder
        int inIndex = inStart;
        while (inorder[inIndex] != preorder[preStart]) {
            inIndex++;
        }
        
        root.left = buildTree(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        // number of nodes in the left subtree is inIndex - inStart
        root.right = buildTree(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        
        return root;
    }
}

/*

use HashMap to store val -> index pair in inorder

*/