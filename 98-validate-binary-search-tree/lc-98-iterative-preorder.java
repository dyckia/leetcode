class Solution {
    private Stack<TreeNode> stack = new Stack<>();
    private Stack<Integer> lStack = new Stack<>();
    private Stack<Integer> uStack = new Stack<>();

    public boolean isValidBST(TreeNode root) {
        
        if (root == null) return true;

        update(root, null, null);

        // dfs pre-order search while keep checking if current node meets condition
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            Integer lower = lStack.pop();
            Integer upper = uStack.pop();
            
            // if equal return false
            if (lower != null && cur.val <= lower) return false;
            if (upper != null && cur.val >= upper) return false;

            if (cur.left != null) update(cur.left, lower, cur.val);
            if (cur.right != null) update(cur.right, cur.val, upper);
        }
        
        return true;
    }

    private void update(TreeNode node, Integer lower, Integer upper) {
        stack.push(node);
        lStack.push(lower);
        uStack.push(upper);
    }
}

/*
Time: O(n)

Space: O(n)
*/