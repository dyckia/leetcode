class Solution {
    // we can do a reverse preorder traversal (root - right -left) 
    // and record the the first element we visited for each level
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res, 1);
        return res;
    }
    
    private void traverse(TreeNode root, List<Integer> vals, int depth) {
        if (root == null) return;

        // root
        if (depth > vals.size()) {
            // we're visiting the first node in that level
            vals.add(root.val);
        }
        // right
        traverse(root.right, vals, depth + 1);
        // left
        traverse(root.left, vals, depth + 1);

        return;
    }
}

/*
Time: O(n)

Space: O(n)
*/