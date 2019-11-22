class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            // push every left child
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // pop and process the root
            cur = stack.pop();
            res.add(cur.val);

            // go right
            cur = cur.right;
        }

        return res;
    }
}