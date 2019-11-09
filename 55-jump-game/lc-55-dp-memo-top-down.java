class Solution {
    public boolean canJump(int[] nums) {
        // instead of checking the same position multiple times
        // we can store that information in memo so we don't need to check again
        // 0 unchecked, 1 reachable, -1 not reachable
        int[] memo = new int[nums.length];
        memo[memo.length - 1] = 1;
        return canJumpFromIndex(nums, 0, memo);
    }

    // check if we can reach the last index from current index
    private boolean canJumpFromIndex(int[] nums, int ind, int[] memo) {
        if (memo[ind] != 0) return memo[ind] == 1 ? true : false;

        int furthestInd = Math.min(ind + nums[ind], nums.length - 1);

        for (int i = ind + 1; i <= furthestInd; i++) {
            // check every possible jump
            if (canJumpFromIndex(nums, i, memo)) {
                memo[ind] = 1;
                return true;
            }
        }
        memo[ind] = -1;
        return false;
    }
}

/*
Time: O(n^2)
For each element i, we need to check nums[i] elements to its right to find a reachable index.

Space: O(2n)
n for the memo
n for the call stack
*/