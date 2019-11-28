// use the value's index in the inorder arrary
// to determine whether a value is in current subtree

class Solution {
    int preInd;
    int[] preArr;
    Map<Integer, Integer> inIndMap;

    public TreeNode bstFromPreorder(int[] preorder) {
        preInd = 0;
        preArr = preorder;
        inIndMap = new HashMap<Integer, Integer>();

        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);
        
        for (int i = 0; i < inorder.length; i++) {
            inIndMap.put(inorder[i], i);
        }

        return helper(0, inorder.length - 1);
    }

    // given the lower and uppper index
    // return the 
    private TreeNode helper(int lower, int higher) {
        if (preInd == preArr.length || lower > higher) return null;

        TreeNode node = new TreeNode(preArr[preInd]);
        preInd++;

        int inInd = inIndMap.get(node.val);

        node.left = helper(lower, inInd - 1);
        node.right = helper(inInd + 1, higher);

        return node;
    }
}