/*
Construct BST from a given inorder traversal. The answer is not unique.
Even if provided with the additional condition that the BST is height balanced.
 
      0           0
     / \         / \
   -3   9      -3   9
   /   /         \   \
 -10  5          -10  5

 
      0            0
     / \          / \
   -3   9       -3   9
    \   /       /     \
   -10  5     -10      5

*/

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // in order to make sure the BST is height balanced
        // each time we pick the mid element in the array
        // we can either choose pick the left mid or right mid
        
        return constructTree(0, nums.length - 1, nums);
    }
    
    private TreeNode constructTree(int left, int right, int[] arr) {
        if (left > right) return null;
        
        // choose right mid element as root
        int mid = left + (right - left) / 2;
        if ((right - left + 1) % 2 == 0) mid++;
        
        
        TreeNode root = new TreeNode(arr[mid]);
        root.left = constructTree(left, mid - 1, arr);
        root.right = constructTree(mid + 1, right, arr);
        
        return root;
    }
    
}