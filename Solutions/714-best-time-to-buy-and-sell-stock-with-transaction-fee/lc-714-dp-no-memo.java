/*
On any given day i, we have two states:
hold[i] - the maximum profit on day i, and we have stock at our hand (after today's action)
empty[i] - the maximum profit on day i, we do not hold a stock (after today's action)

Given day i, and its previous day i - 1
empty[i] = max(empty[i - 1], hold[i - 1] + prices[i])
hold[i] = max(hold[i - 1], empty[i - 1] - prices[i])

empty[0] = 0
hold[0] = -prices[0]

since today's decision only depends on yesterday
we can avoid the two arrays
*/

import java.lang.Math;

class Solution {
    public int maxProfit(int[] prices, int fee) {
        // suppose transaction fee is paid when selling
        int empty = 0;
        int hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            int prevEmpty = empty;
            empty = Math.max(prevEmpty, hold + prices[i] - fee);
            hold = Math.max(hold, prevEmpty - prices[i]);
        }

        return empty;
    }
}

/*
Time: O(n)

Space: O(1)
*/