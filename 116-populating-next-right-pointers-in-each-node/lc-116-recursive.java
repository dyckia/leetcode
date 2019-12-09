class Solution {
    // for each root, we only concern connect its left child and its right child to the correct node
    // if root has left child, it must also has right child
    // if root is not a leaf and has next root, next root mush have left child
    public Node connect(Node root) {
        
        if (root == null) return root;

        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);
        
        return root;
    }
}

/*
Time: O(n)

Space: O(1)
*/