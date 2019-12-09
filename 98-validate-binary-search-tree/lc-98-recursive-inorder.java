class Solution {
    // traverse the tree in in order
    // check if each element in the list is smaller than the next one
    public boolean isValidBST(TreeNode root) {
        Queue<Integer> queue = new LinkedList<>();

        inOrder(root, queue);
        if (queue.isEmpty()) return true;

        int prev = queue.poll();
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if (prev >= cur) return false;
            prev = cur;
        }

        return true;
    }
    
    private void inOrder(TreeNode root, Queue<Integer> queue) {

        if (root == null) return;
        
        inOrder(root.left, queue);
        queue.offer(root.val);
        inOrder(root.right, queue);

        return;
    }
}

/*
Time: O(n)

Space: O(n)
*/