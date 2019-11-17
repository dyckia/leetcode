class Solution {
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        
        dfsAddNodes(root, res, 1);
        
        return res;
    }
    
    // pre order traversal
    // if current row does not exist, create one
    // for even level, insert the val at index 0
    // for odd level, insert the val at end
    private void dfsAddNodes(TreeNode node, List<List<Integer>> res, int level) {
        
        if (node == null) return;

        if (res.size() < level) res.add(new ArrayList<>());
        
        List<Integer> row = res.get(level - 1);
        
        if (level % 2 == 0) {
            row.add(0, node.val);
        } else {
            row.add(node.val);
        }
        
        dfsAddNodes(node.left, res, level + 1);
        dfsAddNodes(node.right, res, level + 1);
        
        return;
    }
}