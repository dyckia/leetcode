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
        // when we find the first leaf node return current depth

        if (root == null) return 0;

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        int depth = 1;
        while (!nodes.isEmpty()) {
            for (int i = nodes.size(); i > 0; i--) {
                TreeNode cur = nodes.poll();
                // found a leaf
                if (cur.left == null && cur.right == null) return depth;
                if (cur.left != null) nodes.offer(cur.left);
                if (cur.right != null) nodes.offer(cur.right);
            }
            depth++;
        }

        return depth;
    }
}

/*
Time: O(n)

Space: O(n)
*/