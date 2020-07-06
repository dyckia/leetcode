class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int res = 0, prev1 = 2, prev2 = 1;
        for (int i = 0; i < n - 2; i++) {
            res = prev1 + prev2;
            prev2 = prev1;
            prev1 = res;
        }
        return res;
    }
}

/*
Time: n

Space: 1
*/