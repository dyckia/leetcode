class Solution {
    
    /*
        we can build a matrix which represents the min sum from
        that coresponding point in grid to the bottom right
        
          1  3  1   x  x  x   x  x  x   x  x  x
          1  5  1   x  x  x   x  x  2   x  3  2
          4  2  1   x  x  1   x  3  1   x  3  1
        
    */
    
    public int minPathSum(int[][] grid) {
        int[][] matrix = buildMatrix(grid);
        
        return matrix[0][0];
    }
    
    private int[][] buildMatrix(int[][] grid) {
        int m = grid.length,
            n = grid[0].length;
        
        int[][] matrix = new int[m][n];
        
        // fill the bottom row
        matrix[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int j = n - 2; j >= 0; j--) {
            matrix[m - 1][j] = grid[m - 1][j] + matrix[m - 1][j + 1];
        }
        
        for (int i = m - 2; i >= 0; i--) {
            matrix[i][n - 1] = grid[i][n - 1] + matrix[i + 1][n - 1];
            for (int j = n - 2; j >= 0; j--) {
                matrix[i][j] = grid[i][j] + Math.min(matrix[i + 1][j], matrix[i][j+1]);
            }
        }
        
        return matrix;
    }
}

/*
 * Time: O(m*n)
 * 
 * Space: O(m*n)
 */