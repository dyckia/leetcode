class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        // i is preorder index, j is inorder index
        for (int i = 1, j = 0; i < preorder.length; i++) {
            TreeNode cur = new TreeNode(preorder[i]);

            // find cur's parent
            TreeNode parent = stack.peek();
            if (stack.peek().val != inorder[j]) {
                // cur's parent is the top node on stack
                // cur is prent's left child
                parent.left = cur;
            } else {
                // cur's parent is the last node on stack whose val == inorder[j].val
                // cur is parent's right child
                while (!stack.isEmpty() && stack.peek().val == inorder[j]) {
                    parent = stack.pop();
                    j++;
                }
                parent.right = cur;
            }

            stack.push(cur);
        }

        return root;
    }
}

/*
Time: O(n)

Space: O(n)
*/