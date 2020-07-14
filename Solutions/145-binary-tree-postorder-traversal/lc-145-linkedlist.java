class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> nodesToAdd = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();

        if (root == null) return res;
        
        nodesToAdd.push(root);
        while(!nodesToAdd.isEmpty()) {
            TreeNode cur = nodesToAdd.pop();
            res.addFirst(cur.val);

            if (cur.left != null) nodesToAdd.push(cur.left);
            if (cur.right != null) nodesToAdd.push(cur.right);
        }

        return res;
    }
}