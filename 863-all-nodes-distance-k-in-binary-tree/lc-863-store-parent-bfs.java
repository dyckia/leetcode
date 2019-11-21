class Solution {
    // since target is given as a TreeNode
    // we don't need to search for that target in the tree
    // use dfs to mark the parent of each node in the tree (HashMap)
    // start from target, use bfs to search for the nodes which are k far from our target
    // use a visited set to prevent us from going back (HashSet)
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null || target == null) return res;

        // add parents using dfs
        Map<TreeNode, TreeNode> parMap = new HashMap<>();
        addParents(root, null, parMap);

        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        // find k distanced nodes using bfs
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        int distance = 0;
        while (!queue.isEmpty() && distance <= K) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode cur = queue.poll();
                if (distance < K) {
                    if (cur.left != null && !visited.contains(cur.left)) {
                    queue.offer(cur.left);
                    visited.add(cur.left);
                    }
                    if (cur.right != null && !visited.contains(cur.right)) {
                        queue.offer(cur.right);
                        visited.add(cur.right);
                    }
                    TreeNode parent = parMap.get(cur);
                    if (parent != null && !visited.contains(parent)) {
                        queue.offer(parent);
                        visited.add(parent);
                    }
                } else {
                    res.add(cur.val);
                }
            }
            distance++;
        }
        return res;
    }

    private void addParents(TreeNode cur, TreeNode parent, Map<TreeNode, TreeNode> parMap) {
        if (cur == null) return;

        parMap.put(cur, parent);

        addParents(cur.left, cur, parMap);
        addParents(cur.right, cur, parMap);

        return;
    }
}