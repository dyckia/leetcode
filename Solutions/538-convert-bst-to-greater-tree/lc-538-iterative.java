class Solution {
    public TreeNode convertBST(TreeNode root) {
        // since it is a binary search tree
        // right > root > left
        // modify the dfs traverse order to right -> root -> left (reverse in-order traversal)
        // while keeping track of the accumulative sum
        
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        int sum = 0;

        while (!stack.isEmpty() || cur != null) {
            
            // right
            while (cur != null) {
                // push all the nodes up to this subtree's bottom right node
                // (including the subtree's root itself) into the stack
                stack.push(cur);
                cur = cur.right;
            }
            
            // root
            cur = stack.pop();
            sum += cur.val;
            cur.val = sum;
            
            // left
            cur = cur.left;
        }
        
        return root;
    }
}

/*
Time: O(n)

Space: O(n)
*/