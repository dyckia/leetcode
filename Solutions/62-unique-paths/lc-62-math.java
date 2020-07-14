class Solution {
    // to get to Finish point, we need to go right m - 1 times and go left n - 1 times
    // the problem reduces to choose m - 1 from m + n -2 slots
    // nCr = n! / (r! * (n - r)!)
    // tricky point here is that we need to avoid int overflow

    public int uniquePaths(int m, int n) {
        // choose the smaller one between m and n
        int min = m < n ? m : n;
        int max = m > n ? m : n;
        long res = 1;

        // (m + n -2)! / ((m - 1)! * (n - 1)!)
        // 8! / (5! * 3!)
        // (8~6)! / 3!
        
        for (int i = 1; i <= min - 1; i++) {
            // be careful of integer division
            res = res * (max - 1 + i) / i;
        }

        return (int) res;
    }
}