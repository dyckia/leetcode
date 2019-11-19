// For BST, the ouput of its in-order traversal is the values in ascending order.
// Thus the problem is equivalent to traverse the tree in in-order in a controlled way.
// Use iterative DFS traversal.

class BSTIterator {
    private Stack<TreeNode> stack;
    TreeNode cur;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        cur = root;
        updateNext();
    }
    
    /** @return the next smallest number */
    public int next() {
        int val = cur.val;
        cur = cur.right;
        updateNext();
        return val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!stack.isEmpty() || cur != null) ? true : false;
    }

    // update the next tree node
    private void updateNext() {
        if (!hasNext()) return;

        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        cur = stack.pop();

        return;
    }
}

/*
Time: O(1) for next() and hasNext() method
hasNext() is O(1) is trivial
next() we can only call next() n time, and we visit each nodes exactly once
thus the asymptotic time for each operation is O(1)

Space: O(h) for the stack
*/