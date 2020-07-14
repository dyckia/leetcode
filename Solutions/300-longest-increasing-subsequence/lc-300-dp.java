class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // memo[i] means the LIS ends at nums[i]
        // memo[i] = Max(memo[j] + 1), nums[j] must be less or equal than nums[i]
        // final answer could end at any index
        int[] memo = new int[nums.length];
        memo[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) max = Math.max(max, memo[j]);
            }
            memo[i] = max + 1;
            res = Math.max(res, memo[i]);
        }
        
        return res;
    }
}

/*
Time: n^2

Space: n
*/