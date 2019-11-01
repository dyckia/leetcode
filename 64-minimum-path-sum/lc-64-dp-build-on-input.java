class Solution {
    
    /*
        we can build a matrix which represents the min sum from
        that coresponding point in grid to the bottom right
        
          1  3  1   x  x  x   x  x  x   x  x  x
          1  5  1   x  x  x   x  x  2   x  3  2
          4  2  1   x  x  1   x  3  1   x  3  1
        
        since the value only depends on its right and beneath neighbors
        we can use the grid to store our matrix
    */
    
    public int minPathSum(int[][] grid) {
        
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i < grid.length - 1 && j < grid[0].length - 1) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
                } else if (i != grid.length - 1) {
                    // rightmost
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                } else if (j != grid[0].length - 1) {
                    // downmost
                    grid[i][j] = grid[i][j] + grid[i][j+1];
                } else {
                    grid[i][j] = grid[i][j];
                }
            }
        }
        
        return grid[0][0];
    }
}

/*
 * Time: O(m*n)
 * 
 * Space: O(1)
 */