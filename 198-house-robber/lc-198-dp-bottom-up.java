class Solution {
    public int rob(int[] nums) {
        if (nums == null) return 0;
        
        int prev1 = 0;
        int prev2 = 0;
        // cur money only depends on prev1 and prev2
        // cur = Math.max(prev2 + n, prev1);
        for (int n : nums) {
            int cur = Math.max(prev2 + n, prev1);
            prev2 = prev1;
            prev1 = cur;
        }
        
        return prev1;
    }
}

/*
Time: n

Space: 1
*/