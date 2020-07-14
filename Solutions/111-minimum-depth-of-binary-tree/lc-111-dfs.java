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
        // use two stacks, one for storing the nodes to be examined
        // one for recording the corrisponding depth

        if (root == null) return 0;

        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> depth = new Stack<>();

        nodes.push(root);
        depth.push(1);

        int min = Integer.MAX_VALUE;
        while (!nodes.isEmpty()) {
            TreeNode curNode = nodes.pop();
            int curDepth = depth.pop();
            // found a leaf
            if (curNode.left == null && curNode.right == null) {
                min = Math.min(min, curDepth);
            }
            if (curNode.right != null) {
                nodes.push(curNode.right);
                depth.push(curDepth + 1);
            }
            if (curNode.left != null) {
                nodes.push(curNode.left);
                depth.push(curDepth + 1);
            }
        }

        return min;
    }
}

/*
Time: O(n)

Space: O(n)
*/