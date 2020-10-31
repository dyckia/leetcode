class Solution {
    // 5^8 = 25^4 = 625^2 = 625*625
    // 5^11 = 25^5 * 5 = 2
    public double myPow(double x, int n) {
        // edge case: n == 0
        if (n == 0) return 1;

        // n could be negative
        // n would overflow if n == -2^8
        long absN = n;
        if (n < 0) {
            x = 1 / x;
            // can not be -n
            absN = -absN;
        }

        double ans = 1;
        double prevProduct = x;
        while (absN > 0) {
            // only update ans when absN is odd
            // absN could eventually be 1
            if (absN % 2 != 0) ans = ans * prevProduct;
            prevProduct = prevProduct * prevProduct;
            absN = absN / 2;
        }

        return ans;
    }
}