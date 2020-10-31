class Solution {
    public double myPow(double x, int n) {
        // n could be negative
        // n would overflow if n == -2^8
        long absN = n;
        if (n < 0) {
            x = 1 / x;
            // can not be -n
            absN = -absN;
        }
        double ans = 1;
        for (int i = 0; i < absN; i++) {
            ans *= x;
        }
        return ans;
    }
}