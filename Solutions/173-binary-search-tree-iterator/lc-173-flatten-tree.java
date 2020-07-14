// Flatten the BST into array list (using recursive in-order traversal)
// Draw backs:
// - the first time we initailize the iterator, it has to traverse the whole tree
// - the array list takes O(n) time

class BSTIterator {
    private List<Integer> vals;
    int index;

    public BSTIterator(TreeNode root) {
        vals = new ArrayList<>();
        getNodesList(root);
        index = -1;
    }
    
    /** @return the next smallest number */
    public int next() {
        index++;
        return vals.get(index);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (index < vals.size() - 1) ? true : false;
    }

    // flatten the BST into an arraylist of Integers
    private void getNodesList(TreeNode node) {
        if (node == null) return;

        getNodesList(node.left);
        vals.add(node.val);
        getNodesList(node.right);

        return;
    }
}

/*
Time: O(n)

Space: O(n)
*/