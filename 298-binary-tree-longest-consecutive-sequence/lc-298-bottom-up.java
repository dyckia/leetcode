class Solution {
    int maxL;
    
    public int longestConsecutive(TreeNode root) {
        maxL = 0;
        
        postOrder(root);
        
        return maxL;
    }
    
    // return the longest consecutive length starting from current node
    private int postOrder(TreeNode cur) {
        if (cur == null) return 0;
        
        // cur is not null
        int len = 1;
        
        int left = postOrder(cur.left);
        if (left != 0 && cur.val + 1 == cur.left.val) len = Math.max(len, left + 1);
        
        int right = postOrder(cur.right);
        if (right != 0 && cur.val + 1 == cur.right.val) len = Math.max(len, right + 1);
        
        maxL = Math.max(maxL, len);
        
        return len;
    }
}

/*
Time: O(n)

Space: O(n)
*/