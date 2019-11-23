class Solution {
    // for each level, we connect the nodes in the next level
    // in order to connect the right child node to the left child in the other branch
    // use current root's next pointer
    public Node connect(Node root) {
        
        Node levelStart = root;

        while (levelStart != null) {
            Node cur = levelStart;
            while (cur != null) {
                // if cur node is not a leaf, it must contains both left and right child
                if (cur.left != null) cur.left.next = cur.right;
                // if cur node is not a leaf, and has next branch
                // connect cur's right node to next branch's left node
                if (cur.left != null cur.next != null && ) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            levelStart = levelStart.left;
        }

        return root;
    }
}