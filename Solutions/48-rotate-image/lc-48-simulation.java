class Solution {

    /*
     * we rotate the matrix layer by layer (from outer layer to innner layer)
     * 
     *  1  2  3  4  5 
     *  6  7  8  9 10 
     * 11 12 13 14 15 
     * 16 17 18 19 20 
     * 21 22 23 24 25
     * 
     * 
     * For element [r][c] the swaps are:
     * [r][c] -> [c][n - 1 - r] -> [n - 1 - r, n - 1 - c] -> [n - 1 - c, r]
     * 
     * for row, end condition is row < n / 2
     * 
     * for column, end condition is col < n - row - 1
     */

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        for (int row = 0; row < n / 2; row++) {
            for (int col = row; col < n - row - 1; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[n - 1 - col][row];
                matrix[n - 1 - col][row] = matrix[n - 1 - row][n - 1 - col];
                matrix[n - 1 - row][n - 1 - col] = matrix[col][n - 1 - row];
                matrix[col][n - 1 - row] = temp;
            }
        }

        return;
    }

}

/*
Time: O(n^2)

Space: O(1)
*/