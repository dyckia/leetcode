import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> pDeque = new ArrayDeque<>();
        Deque<TreeNode> qDeque = new ArrayDeque<>();

        findPath(root, p, pDeque);
        findPath(root, q, qDeque);
        
        TreeNode res = root;
        while (!pDeque.isEmpty() && !qDeque.isEmpty()) {
            TreeNode node1 = pDeque.pollFirst();
            TreeNode node2 = qDeque.pollFirst();
            if (node1.val == node2.val) res = node1;
        }

        return res;
    }

    // return true if node is in the path to target
    private boolean findPath(TreeNode node, TreeNode target, Deque<TreeNode> deque) {
        
        if (node == null) return false;
        if (node.val == target.val) {
            deque.offerFirst(node);
            return true;
        }

        if (findPath(node.left, target, deque) || findPath(node.right, target, deque)) {
            deque.offerFirst(node);
            return true;
        }

        return false;
    }
}

/*
Time: O(n)
We can modify the function to use one traversal to find path for both p and q

Space: O(depth)
*/