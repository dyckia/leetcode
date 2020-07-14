class Solution {
    public int trailingZeroes(int n) {
        // denominator could be larger than 5
        long denominator = 5;
        int res = 0;
        // loop is to find mutiples of 5, i.e. 25, 125...
        while (n / denominator >= 1) {
            // 31 / 5 = 6 means there are six numbers which are mutiple of 5
            // 31/25 = 1 means there is one number that has two factors of 5
            res += n / denominator;
            denominator *= 5;
        }
        
        return res;
    }
}

/*
Time: logn

Space: 1
*/