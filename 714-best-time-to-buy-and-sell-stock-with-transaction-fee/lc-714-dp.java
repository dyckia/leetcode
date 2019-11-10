/*
On any given day i, we have two states:
hold[i] - the maximum profit on day i, and we have stock at our hand (after today's action)
empty[i] - the maximum profit on day i, we do not hold a stock (after today's action)

Given day i, and its previous day i - 1
empty[i] = max(empty[i - 1], hold[i - 1] + prices[i])
hold[i] = max(hold[i - 1], empty[i - 1] - prices[i])

empty[0] = 0
hold[0] = -prices[0]
*/

import java.lang.Math;

class Solution {
    public int maxProfit(int[] prices, int fee) {
        // suppose transaction fee is paid when selling
        int[] empty = new int[prices.length];
        int[] hold = new int[prices.length];
        empty[0] = 0;
        hold[0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            empty[i] = Math.max(empty[i - 1], hold[i - 1] + prices[i] - fee);
            hold[i] = Math.max(hold[i - 1], empty[i - 1] - prices[i]);
        }

        return empty[prices.length - 1];
    }
}

/*
Time: O(n)

Space: O(2n)
*/