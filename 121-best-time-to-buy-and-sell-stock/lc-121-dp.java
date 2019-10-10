class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        
        int maxEarn = 0;
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int curPrice = prices[i];
            if (curPrice >= buyPrice) {
                maxEarn = Math.max(maxEarn, curPrice - buyPrice);
            } else {
                // because curPrice is less than buyPrice
                // for all the future sales, the earning of curPrice would be higher than buyPrice
                buyPrice = curPrice;
            }
        }
        
        return maxEarn;
    }
}