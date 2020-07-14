import java.lang.Math;

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        
        int max = 0;

        while(!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = size; i > 0; i--) {
                TreeNode node = nodes.poll();
                if (node.left != null) nodes.offer(node.left);
                if (node.right != null) nodes.offer(node.right);
            }
            max++;
        }

        return max;
    }
}

/*
 * Time: O(n)
 * 
 * Space: O(n)
 */