class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            TreeNode parent = stack.peek();

            // stop before the first node greater than cur node
            while (!stack.isEmpty() && node.val > stack.peek().val) {
                parent = stack.pop();
            }

            if (node.val < parent.val) {
                // node is on the left side
                parent.left = node;
            } else {
                // node is on the right side
                parent.right = node;
            }
            
            stack.push(node);
        }

        return root;
    }
}

/*
Time: O(n)

Space: O(n)
*/