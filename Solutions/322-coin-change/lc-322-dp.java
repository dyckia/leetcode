class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        int[] memo = new int[amount + 1];
        // -2 means hasn't been calculated
        Arrays.fill(memo, -2);
        memo[0] = 0;
        return dp(coins, amount, memo);
    }
    
    private int dp(int[] coins, int amount, int[] memo){
        if (amount < 0) return -1;
        // already calculated
        if (memo[amount] != -2) return memo[amount];
        int n = Integer.MAX_VALUE;
        for (int coin : coins) {
            int temp = dp(coins, amount - coin, memo);
            if (temp >= 0) n = Math.min(n, temp + 1);
        }
        
        memo[amount] = (n == Integer.MAX_VALUE) ? -1 : n;
        return memo[amount];
    }
}

/*
Time: m * n
m is the amount
n is number of coin denominations

Space: m
*/