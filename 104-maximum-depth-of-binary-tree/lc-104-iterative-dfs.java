import java.lang.Math;

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> depths = new Stack<>();

        nodes.push(root);
        depths.push(1);
        int max = 0;

        while(!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            int curDepth = depths.pop();
            max = Math.max(max, curDepth);
            if (node.left != null) {
                nodes.push(node.left);
                depths.push(curDepth + 1);
            }
            if (node.right != null) {
                nodes.push(node.right);
                depths.push(curDepth + 1);
            }
        }

        return max;
    }
}

/*
 * Time: O(n)
 * 
 * Space: O(n)
 */