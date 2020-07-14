class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curRow = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode curNode = queue.poll();
                curRow.add(curNode.val);
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }

            res.add(curRow);
        }

        return res;
    }
}

/*
 * Time: O(n)
 * 
 * Space: O(n)
 */