class Solution {
    int maxL;
    
    public int longestConsecutive(TreeNode root) {
        maxL = 0;
        
        preOrder(root, null, 1);
        
        return maxL;
    }
    
    private void preOrder(TreeNode cur, TreeNode par, int len) {
        if (cur == null) return;
        
        if (par != null && cur.val == par.val + 1) len++;
        else len = 1;
        
        maxL = Math.max(maxL, len);

        preOrder(cur.left, cur, len);
        preOrder(cur.right, cur, len);
        
        return;
    }
}

/*
Time: O(n)

Space: O(n)
*/