class Solution {
    // use two stacks
    // one for storing element in cur level
    // one for storing elements in the next level
    // use one boolean flag to indicate level
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        
        if (root == null) return res;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Boolean isOdd = true;
        
        while (!stack.isEmpty()) {
            List<Integer> curRow = new ArrayList<>();
            Stack<TreeNode> nextStack = new Stack<>();
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                curRow.add(cur.val);
                if (isOdd) {
                    if (cur.left != null) nextStack.push(cur.left);
                    if (cur.right != null) nextStack.push(cur.right);
                } else {
                    if (cur.right != null) nextStack.push(cur.right);
                    if (cur.left != null) nextStack.push(cur.left);
                }
            }
            res.add(curRow);
            isOdd = !isOdd;
            stack = nextStack;
        }
        
        return res;
    }
}