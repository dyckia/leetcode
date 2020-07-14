// inorder traversal outputs the values in BST in ascending order

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            k--;
            if (k == 0) return cur.val;

            cur = cur.right;
        }
        
        return -1;
    }
}

/*
Time: O(n)

Space: O(n)
*/