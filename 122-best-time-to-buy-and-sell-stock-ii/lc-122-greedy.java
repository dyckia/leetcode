class Solution {
    public int maxProfit(int[] prices) {
        // instead of keeping track of the bought price
        // we add the profit on every day if prices[i] > prices[i-1]
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}