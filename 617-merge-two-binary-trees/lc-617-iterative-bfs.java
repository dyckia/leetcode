// iterative level-order traversal (BFS)
// merge t2 into t1

class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[] {t1, t2});
        
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                // [0] and [1] must be not null
                TreeNode[] nodeArr = queue.poll();
                nodeArr[0].val += nodeArr[1].val;
                if (nodeArr[0].left == null && nodeArr[1].left != null) {
                    // replace with [1]'s child, no need to offer
                    nodeArr[0].left = nodeArr[1].left;
                } else if (nodeArr[0].left != null && nodeArr[1].left != null) {
                    queue.offer(new TreeNode[] {nodeArr[0].left, nodeArr[1].left});
                }
                // [1]'s child is null, do nothing
                
                if (nodeArr[0].right == null && nodeArr[1].right != null) {
                    // replace with [1]'s child, no need to offer
                    nodeArr[0].right = nodeArr[1].right;
                } else if (nodeArr[0].right != null && nodeArr[1].right != null) {
                    queue.offer(new TreeNode[] {nodeArr[0].right, nodeArr[1].right});
                }
            }
        }
        
        return t1;
    }
}

/*
Time: O(m)
m is the smaller number of nodes in the two trees

Space: O(m)
*/