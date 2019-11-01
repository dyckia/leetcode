class Solution {
    public int minPathSum(int[][] grid) {
        // since we can only go down or right
        // given any point(i, j) in the grid, the minPath to point(m, n) is equal to
        // Min(val(down) + minPath(i+1, j), val(right) + minPath(i, j+1)) if both directions are available
        // use memoization to avoid repeated computing

        int[][] memo = new int[grid.length][grid[0].length];
            
        return grid[0][0] + minPathSum(grid, 0, 0, memo);
    }

    // the min path sum from point(row, col) in the grid to (m, n)
    private int minPathSum(int[][] grid, int row, int col, int[][] memo) {

        if (memo[row][col] != 0) return memo[row][col];

        int m = grid.length - 1;
        int n = grid[0].length - 1;

        // reached the bottom right
        // we don't need to return grid[m][n] 
        // becuase it's already been added in the previous step
        if (row == m && col == n) return 0;

        // reached the bottom, can only go right
        if (row == m && col < n) return grid[row][col + 1] + minPathSum(grid, row, col + 1, memo);

        // reached the right bound, can only go down
        if (row < m && col == n) return grid[row + 1][col] + minPathSum(grid, row + 1, col, memo);

        // can either go down or go right
        int down = grid[row][col + 1] + minPathSum(grid, row, col + 1, memo);
        int right = grid[row + 1][col] + minPathSum(grid, row + 1, col, memo);
        
        memo[row][col] = Math.min(down, right);

        return memo[row][col];
    }
}

/*
 * Time: O(m*n)
 * 
 * Space: O(m*n)
 */