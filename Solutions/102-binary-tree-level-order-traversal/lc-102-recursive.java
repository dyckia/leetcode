class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        preorder(root, 1, res);

        return res;
    }

    // build res recursively using preorder traversal
    private void preorder(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) return;

        // cur row does not exist, create a new row
        if (res.size() < level) {
            List<Integer> newRow = new ArrayList<>();
            res.add(newRow);
        }

        // retrieve the row of this level
        List<Integer> curRow = res.get(level - 1);

        // add root value to current row
        curRow.add(root.val);

        // recursively add left and right node if not null
        preorder(root.left, level + 1, res);
        preorder(root.right, level + 1, res);

        return;
    }
}

/*
Time: O(n)

Space: O(n)
*/