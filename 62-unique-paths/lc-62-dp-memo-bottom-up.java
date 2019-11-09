class Solution {
    
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        
        // construct memo matrix from bottom up
        for (int row = m - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                if (row == m - 1 || col == n - 1) memo[row][col] = 1;
                else memo[row][col] = memo[row + 1][col] + memo[row][col + 1];
            }
        }
        
        return memo[0][0];
    }

}

/*
Time: O(m*n)

Space: O(m*n)
we can further reduce the space to n since cur row only depends on previous row
    
public int uniquePaths(int m, int n) {
    int[] memo = new int[n];
    
    // construct memo matrix from bottom up
    for (int row = m - 1; row >= 0; row--) {
        for (int col = n - 1; col >= 0; col--) {
            if (row == m - 1 || col == n - 1) memo[col] = 1;
            else memo[col] = memo[col] + memo[col + 1];
        }
    }
    
    return memo[0];
}
*/