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

        // one of its children is not null or both not null
        int min = Integer.MAX_VALUE;

        if (root.left != null) {
            min = Math.min(min, minDepth(root.left));
        }

        if (root.right != null) {
            min = Math.min(min, minDepth(root.right));
        }
        
        return min + 1;
    }
}

/*
Time: O(n)

Space: O(n)
*/