class Solution {
    public boolean canJump(int[] nums) {
        // instead of using recursion
        // we can construct the memo using bottom up approach
        // we start from the end of the array
        // and iteratively build the memo 
        
        int[] memo = new int[nums.length];
        memo[memo.length - 1] = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestInd = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestInd; j++) {
                // memo[j] must not be 0 since we've already visited
                if (memo[j] == 1) {
                    memo[i] = 1;
                    break;
                }
            }
        }

        return memo[0] == 1 ? true : false;
    }
}

/*
Time: O(n^2)
For each element i, we need to check nums[i] elements to its right to find a reachable index.

Space: O(n)
n for the memo
*/