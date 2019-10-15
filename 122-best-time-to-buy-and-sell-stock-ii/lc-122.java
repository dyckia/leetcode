class Solution {
    public int maxProfit(int[] prices) {
        // if we're holding stock
        // sell if the price decreases on the next day
        // hold if the price increases on the next day
        
        // if we are not holding stock 
        // buy if the price increases on the next day
        // hold if the price decrease on the next day
        
        // do nothing if the price does not change
        
        int profit = 0;
        // -1 means we do not hold stock 
        int boughtPrice = -1;
        
        int cur = 0;
        
        while (cur < prices.length-1) {
            if (prices[cur] < prices[cur+1]) {
                if(boughtPrice == -1) {
                    boughtPrice = prices[cur];
                }
            } else if (prices[cur] > prices[cur+1]) {
                if(boughtPrice != -1) {
                    profit += (prices[cur] - boughtPrice);
                    boughtPrice = -1;
                }
            }
            cur++;
        }
        
        if (boughtPrice != -1) {
            profit += (prices[cur] - boughtPrice);
        }
        
        return profit;
    }
}