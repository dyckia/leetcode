/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    // last visited node
    Node last = null;
    // first visited node (smallest node)
    Node first = null;

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;

        convertTree(root);

        // connect tail to head
        first.left = last;
        last.right = first;
        return first;
    }

    private void convertTree(Node node) {
        // go deep on the left side
        if (node.left != null) {
            convertTree(node.left);
        }

        // link last node with current node
        if (first == null) {
            first = node;
        } else {
            last.right = node;
            node.left = last;
        }
        last = node;

        // go deep on the right side
        if (node.right != null) {
            convertTree(node.right);
        }
    }
}