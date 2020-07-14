class Solution {

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        return uniquePaths(m, n, 0, 0, memo);
    }

    // given current position (x, y) return number of unique paths
    private int uniquePaths(int m, int n, int x, int y, int[][] memo) {

        if (memo[x][y] == 0) {
            // base case: reach boundary
            if (x == m - 1 || y == n - 1) {
                memo[x][y] = 1;
            } else {
                memo[x][y] = uniquePaths(m, n, x + 1, y, memo) + uniquePaths(m, n, x, y + 1, memo);
            }
        }

        return memo[x][y];
    }

}

/*
Time: O(m*n)

Space: O(m*n)
memo and call stack
*/