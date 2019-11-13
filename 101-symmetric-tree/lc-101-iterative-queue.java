// use queue to simulate the way we traverse the tree (special DFS)
// for each two consecutive nodes in the queue
// their value should be the same

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node1 = q.poll();
            TreeNode node2 = q.poll();
            if (node1 == null && node2 == null)
                continue;
            if (node1 == null || node2 == null || node1.val != node2.val)
                return false;
            q.add(node1.left);
            q.add(node2.right);
            q.add(node1.right);
            q.add(node2.left);
        }

        return true;
    }
}

/*
Time: O(n)

Space: O(n)
In the worst case, we have to insert O(n)O(n) nodes in the queue.
*/