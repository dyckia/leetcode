class Solution {
    // normal BFS traversal (use queue)
    // use a boolean flag to indicate the direction
    // when direction is right to left, insert val at index 0
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        
        if (root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Boolean rightToLeft = false;
        
        while (!queue.isEmpty()) {
            List<Integer> vals = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode cur = queue.poll();

                if (rightToLeft) vals.add(0, cur.val);
                else vals.add(cur.val);

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(vals);
            rightToLeft = !rightToLeft;
        }
        
        return res;
    }
}