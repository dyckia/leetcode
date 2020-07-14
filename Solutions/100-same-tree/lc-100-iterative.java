class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(p);
        nodes.push(q);
        
        while (!nodes.isEmpty()) {
            // every two consecutive nodes are the nodes 
            // from p and q in the same position 
            TreeNode m = nodes.pop();
            TreeNode n = nodes.pop();
            if (oneIsNull(m, n)) return false;
            
            if (m == null && n == null) continue;
            
            // both m and n are not null
            if (m.val != n.val) return false;
            nodes.push(m.right);
            nodes.push(n.right);
            nodes.push(m.left);
            nodes.push(n.left);
        }
        
        return true;
    }
    
    private boolean oneIsNull(TreeNode m, TreeNode n) {
        if (m != null && n == null) return true;
        if (m == null && n != null) return true;
        return false;
    }
}

/*
Time: O(n)

Space: O(n)
*/