class Solution {
    // brute force
    public int minPathSum(int[][] grid) {
        return minSum(grid, 0, 0);
    }
    
    private int minSum(int[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        
        return grid[i][j] + Math.min(minSum(grid, i + 1, j), minSum(grid, i, j + 1));
    }
}

/*
 * Time: O(2^(m+n))
 * For every move, we have 2 options and we have total (m + n) moves
 * 
 * 
 * Space:O(m + n)
 * Call stack
 */