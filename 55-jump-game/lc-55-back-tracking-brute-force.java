class Solution {
    public boolean canJump(int[] nums) {
        return canJumpFromIndex(nums, 0);
    }

    // check if we can reach the last index from current index
    private boolean canJumpFromIndex(int[] nums, int ind) {
        int furthestInd = ind + nums[ind];

        if (furthestInd >= nums.length - 1) return true;

        for (int i = ind + 1; i <= furthestInd; i++) {
            // check every possible jump
            if (canJumpFromIndex(nums, i)) return true;
        }

        return false;
    }
}

/*
Time: O(n!)

Space: O(n)
*/