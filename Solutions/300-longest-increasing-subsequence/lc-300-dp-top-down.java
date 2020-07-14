class Solution {
    int[] memo;
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // dp[i] means the LIT of subarray ends at nums[i] [0, i]
        // dp[i] = Max(dp[j] + 1), nums[j] must be less or equal than nums[i]
        // final answer could end at any index
        memo = new int[nums.length];
        memo[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, helper(nums, i));
        }
        
        return res;
    }

    // return the LIT of subarray from 0 to end
    private int helper(int[] nums, int end) {
        if (memo[end] != 0) return memo[end];
        int max = 0;
        for (int i = 0; i < end; i++) {
            if (nums[i] < nums[end]) {
                max = Math.max(max, helper(nums, i));
            }
        }
        memo[end] = max + 1;
        return memo[end];
    }
}