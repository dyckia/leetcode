class Solution {
    int[] postArr;
    int postInd;
    Map<Integer, Integer> inIndMap;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postArr = postorder;
        postInd = postArr.length - 1;
        inIndMap = new HashMap<>();
        addToMap(inorder);
        return helper(0, inorder.length - 1);
    }


    private TreeNode helper(int inStart, int inEnd) {
        if (postInd < 0 || inStart > inEnd) return null;

        TreeNode node = new TreeNode(postArr[postInd]);
        postInd--;
        int inInd = inIndMap.get(node.val);

        // start from right subtree
        node.right = helper(inInd + 1, inEnd);
        node.left = helper(inStart, inInd - 1);

        return node;
    }

    private void addToMap(int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inIndMap.put(inorder[i], i);
        }
        return;
    }
}

/*
Time: O(n)

Space: O(n)
*/