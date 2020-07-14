// iterative preorder traversal (DFS)
// merge t2 into t1
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] {t1, t2});

        while (!stack.isEmpty()) {
            TreeNode[] nodeArr = stack.pop();
            // nodeArr[0] and nodeArr[1] must be not null
            nodeArr[0].val += nodeArr[1].val;

            if (nodeArr[0].right == null) {
                // if node1's child is null -> replace with node2's child
                nodeArr[0].right = nodeArr[1].right;
            } else if (nodeArr[1].right != null) {
                // if both children are not null -> update value and push
                stack.push(new TreeNode[] {nodeArr[0].right, nodeArr[1].right});
            } 
            // else node2's child is null -> do nothing
            
            if (nodeArr[0].left == null) {
                nodeArr[0].left = nodeArr[1].left;
            } else if (nodeArr[1].left != null) {
                stack.push(new TreeNode[] {nodeArr[0].left, nodeArr[1].left});
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