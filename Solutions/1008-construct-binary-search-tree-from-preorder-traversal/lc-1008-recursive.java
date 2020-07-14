// the first number is the root
// following numbers which are less than root are in the left subtree
// numbers which are greater than root are in the right subtree
class Solution {
    int ind;
    int[] arr;

    public TreeNode bstFromPreorder(int[] preorder) {
        ind = 0;
        arr = preorder;

        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode helper(int low, int high) {
        if (ind >= arr.length) return null;

        int val = arr[ind];
        // included low > high
        if (val < low || val > high) return null;

        TreeNode node = new TreeNode(val);
        ind++;

        node.left = helper(low, val - 1);
        node.right = helper(val + 1, high);

        return node;
    }
}

/*
Time: O(n)

Space: O(n)
*/