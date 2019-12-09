class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> leftList = new LinkedList<>(),
                      leafList = new LinkedList<>(),
                      rightList = new LinkedList<>();
        
        preorder(root, 0, leftList, leafList, rightList);

        leftList.addAll(leafList);
        leftList.addAll(rightList);

        return leftList;
    }

    // preorder traversal
    // flag 0 - root, 1 - leftBoundary, 2 - leaves, 3 - rightBoundary, 4 - others
    private void preorder(TreeNode root, int flag, List<Integer> leftList, List<Integer> leafList, List<Integer> rightList) {
        if (root == null) return;

        if (flag == 0 || flag == 1) leftList.add(root.val);
        else if (flag == 2) leafList.add(root.val);
        else if (flag == 3) rightList.add(0, root.val);

        preorder(root.left, flagForLeftChild(root, flag), leftList, leafList, rightList);
        preorder(root.right, flagForRightChild(root, flag), leftList, leafList, rightList);

        return;
    }


    private int flagForLeftChild(TreeNode cur, int flag) {
        if (flag == 2 || cur.left == null) return 4;
        if (isLeaf(cur.left)) return 2;

        if (flag == 0) return 1;
        if (flag == 1) return 1;
        if (flag == 3) return (cur.right == null) ? 3 : 4;
        if (flag == 4) return 4;
        
        return -1;
    }

    private int flagForRightChild(TreeNode cur, int flag) {
        if (flag == 2 || cur.right == null) return 4;
        if (isLeaf(cur.right)) return 2;

        if (flag == 0) return 3;
        if (flag == 1) return (cur.left == null) ? 1 : 4;
        if (flag == 3) return 3;
        if (flag == 4) return 4;
        
        return -1;
    }
    
    private boolean isLeaf(TreeNode cur) {
        return (cur.left == null && cur.right == null);
    }
}

/*
Time: O(n)

Space: O(n)
*/