public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        
        StringBuilder sb = new StringBuilder();
        postorder(root, sb);
        //remove tailing space
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    private void postorder(TreeNode root, StringBuilder sb) {
        if (root == null) return;

        sb.append(root.val);
        sb.append(" "); //delimiter
        postorder(root.left, sb);
        postorder(root.right, sb);

        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        
        Queue<Integer> nums = new LinkedList<>();
        for (String str : data.split("\\s+")) {
            // notice here we will reverse the order of the string
            nums.offer(Integer.valueOf(str));
        }
        
        return buildTree(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
    }

    private TreeNode buildTree(int lower, int upper, Queue<Integer> nums) {
        if (nums.isEmpty()) return null;

        int curVal = nums.peek();
        // curVal not in cur subtree
        if (curVal < lower || curVal > upper) return null;

        nums.pop();
        TreeNode curNode = new TreeNode(curVal);

        // left comes first
        curNode.left = buildTree(lower, curVal, nums);
        curNode.right = buildTree(curVal, upper, nums);
        
        return curNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));