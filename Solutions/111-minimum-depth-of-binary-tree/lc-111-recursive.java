import java.lang.Math;

/*
The minimum depth is the number of nodes along the 
shortest path from the root node down to the nearest leaf node.

A leaf is a node with no children.

Example: 
    3
   / \
  9  N
Should return 2 since 9 is the only leaf in this tree
*/

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        // found a leaf
        if (root.left == null && root.right == null) return 1;
        // one of its children is null
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        return Math.min(left, right) + 1;
    }
}

/*
Time: O(n)

Space: O(n)
*/