import java.lang.Math;

class Solution {
    // any path can be written as two arrows
    // (in different directions) from some node
    // where an arrow is a path that starts at some node
    // and only travels down to child nodes

    int maxLen = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return maxLen;
    }

    private int getDepth(TreeNode node) {
        if (node == null)
            return 0;

        int left = getDepth(node.left);
        int right = getDepth(node.right);
        maxLen = Math.max(maxLen, left + right);

        return Math.max(left, right) + 1;
    }
}

/*
 * Time: O(n) we visit every node only once
 * 
 * Space: O(n) for the call stack
 */