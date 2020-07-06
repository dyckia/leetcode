class Solution {
    int[] memo;
    
    public int climbStairs(int n) {
        memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        
        return dp(n);
    }
    
    private int dp(int stairs) {
        if(memo[stairs] == 0) 
            memo[stairs] = dp(stairs - 1) + dp(stairs - 2);
        
        return memo[stairs];
    }
}

/*
Time: n

Space: n
*/