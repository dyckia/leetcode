class Solution {
    // 5^8 = 25^4 = 625^2 = 625*625
    // 5^9 = 25^4 * 5
    private double fastPow(double x, long n) {
        // base case n == 0 or n == 1
        if (n == 0) return 1;
        if (n == 1) return x;

        if (n % 2 == 0) return fastPow(x * x, n / 2);
        return fastPow(x * x, n / 2) * x;
    }


    public double myPow(double x, int n) {
        // n could be negative
        // n would overflow if n == -2^8
        long absN = n;
        if (n < 0) {
            x = 1 / x;
            // can not be -n
            absN = -absN;
        }
        return fastPow(x, absN);
    }
}