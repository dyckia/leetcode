class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> nodesToAdd = new Stack<>();
        Stack<TreeNode> postOrder = new Stack<>();
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;
        
        nodesToAdd.push(root);
        while(!nodesToAdd.isEmpty()) {
            TreeNode cur = nodesToAdd.pop();
            postOrder.push(cur);

            if (cur.left != null) nodesToAdd.push(cur.left);
            if (cur.right != null) nodesToAdd.push(cur.right);
        }

        while(!postOrder.isEmpty()) {
            res.add(postOrder.pop().val);
        }

        return res;
    }
}