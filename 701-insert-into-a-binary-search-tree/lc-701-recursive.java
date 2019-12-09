// place the new node to the child position of current leaf

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // we found a leaf, create a new node
        if (root == null) return new TreeNode(val);

        // insert into left
        if (root.val > val) root.left = insertIntoBST(root.left, val);
        // insert into right
        else root.right = insertIntoBST(root.right, val);

        return root;
    }
}


/*
Time: O(H)

Space: O(H)
Recursive call stack
*/