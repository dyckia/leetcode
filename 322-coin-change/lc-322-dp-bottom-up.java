class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    // previous dp must have been calculated
                    // memo[i - coin] < 0 means not possible
                    if (memo[i - coin] >= 0) {
                        memo[i] = (memo[i] == -1) ? memo[i - coin] + 1 : Math.min(memo[i], memo[i - coin] + 1);
                    }
                }
            }
        }
        
        return memo[amount];
    }
}

/*
Time: m * n
m is the amount
n is number of coin denominations

Space: m
*/