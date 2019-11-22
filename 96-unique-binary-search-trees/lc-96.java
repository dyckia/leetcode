/*
Think about an array [1, 2, 3, ... n]. If we choose k as the root, then 
- Its left subtree can only contain numbers from 1 to k-1.
- Its right subtree can only contain numbers from k+1 to n.
- The total combination for unqiue binary trees with k being the root would be count_left * count_right.
- Each number in the array can either be picked as the root or not.

Use memoization to store the number of unique trees we've computed.
*/

class Solution {
    public int numTrees(int n) {
        // memoization table
        Integer[] memo = new Integer[n + 1];
        // subtree is null or just one node
        memo[0] = 1;
        memo[1] = 1;

        return numTrees(n, memo);
    }

    private int numTrees(int n, Integer[] memo) {
        if (memo[n] != null) return memo[n];

        // pick each node as the root node
        int count = 0;
        for (int i = 1; i <= n; i++) {
            // number of possibilities of left subtree
            int left = numTrees(i - 1, memo);
            int right = numTrees(n - i, memo);
            count += (left * right);
        }

        memo[n] = count;
        return count;
    }
}