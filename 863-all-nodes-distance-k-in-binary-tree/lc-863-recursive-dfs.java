/*
    use dfs to find target from root
    if cur node is the target
       1. search the subtree from cur node and add nodes K far from cur node
    if cur node is in the path from root to target
       1. check is current node is k distance from target
       2. search the subtree which does not contain the target
            - assume left subtree contains target and left node is l far from target
            - then add nodes in right subtree K - l - 2 far from right node
*/
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();

        dfs(root, target, K, res);
        return res;
    }

    // use dfs to find target from root, return the distance from current node to the traget node
    // return -1 if current node is not on the path from root to target
    private int dfs(TreeNode node, TreeNode target, int K, List<Integer> res) {
        if (node == null) return -1;

        if (node.val == target.val) {
            // add nodes from current subtree
            addNodes(node, K, res);
            return 0;
        }

        int left = dfs(node.left, target, K, res);
        int right = dfs(node.right, target, K, res);
        
        // at most one of left and right could be not -1
        if (right != -1) {
            // current node is k far from target
            if (K == right + 1) res.add(node.val);
            // target is in the right subtree, add nodes in left subtree
            else addNodes(node.left, K - right - 2, res);
            return right + 1;
        }

        if (left != -1) {
            // current node is k far from target
            if (K == left + 1) res.add(node.val);
            // target is in the left subtree, add nodes in right subtree
            else addNodes(node.right, K - left - 2, res);
            return left + 1;
        }

        // both left and right are - 1
        return -1;
    }
    
    // add all the child nodes which are l distrance far from current root
    private void addNodes(TreeNode root, int l, List<Integer> res) {
        if (l < 0 || root == null) return;

        if (l == 0) {
            res.add(root.val);
            return;
        }

        // l > 0
        addNodes(root.left, l - 1, res);
        addNodes(root.right, l - 1, res);
        return;
    }
}

/*
Time: O(n)

Space: O(n)
*/