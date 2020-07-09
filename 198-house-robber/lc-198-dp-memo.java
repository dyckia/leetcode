class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int len = nums.length;
        int[] memo = new int[len + 1];
        Arrays.fill(memo, -1);
        memo[len] = 0;
        memo[len - 1] = nums[len - 1];
        memo[len - 2] = Math.max(nums[len - 1], nums[len - 2]);
        return dp(nums, 0, memo);
    }
    
    
    // return the max money in sub-array [start, nums.length() - 1]
    private int dp(int[] nums, int start, int[] memo) {
        if (memo[start] != -1) return memo[start];
        
        // rob start
        int amount1 = nums[start] + dp(nums, start + 2, memo);
        // skip start, rob start + 1
        int amount2 = nums[start + 1] + dp(nums, start + 3, memo);
        memo[start] = Math.max(amount1, amount2);
        
        return memo[start];
    }
}

/*
Time: n

Space: n
*/