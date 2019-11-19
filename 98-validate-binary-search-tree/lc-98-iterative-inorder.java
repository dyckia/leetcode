class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Integer prev = null;
        TreeNode cur = root;

        // needs cur != null in while condition
        // as when cur == root.right stack is empty
        while (!stack.isEmpty() || cur != null) {
            // go to the bottom left
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (prev != null && cur.val <= prev) return false;
            prev = cur.val;

            cur = cur.right;
        }

        return true;
    }
}