class Solution {
    
    /*
        we can build a matrix which represents the min sum from
        that coresponding point in grid to the bottom right
        
          1  3  1   x  x  x   x  x  x   x  x  x
          1  5  1   x  x  x   x  x  2   x  3  2
          4  2  1   x  x  1   x  3  1   x  3  1
        
        since the cur row only depends on the right element and beneath element
        we can just store one single row
    */
    
    public int minPathSum(int[][] grid) {
        
        int[] row = new int[grid[0].length];
        
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i < grid.length - 1 && j < grid[0].length - 1) {
                    row[j] = grid[i][j] + Math.min(row[j], row[j + 1]);
                } else if (i != grid.length - 1) {
                    // rightmost
                    row[j] = grid[i][j] + row[j];
                } else if (j != grid[0].length - 1) {
                    // downmost
                    row[j] = grid[i][j] + row[j+1];
                } else {
                    row[j] = grid[grid.length - 1][grid[0].length - 1];
                }
            }
        }
        
        return row[0];
    }
}

/*
 * Time: O(m*n)
 * 
 * Space: O(n) for the row
 */