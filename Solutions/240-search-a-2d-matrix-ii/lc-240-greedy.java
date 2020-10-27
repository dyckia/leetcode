// start from bottom left, if target > cur, go right, otherwise go up

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // matrix is null or empty
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            int cur = matrix[row][col];
            if (cur == target)
                return true;
            else if (cur < target)
                col++;
            else
                row--;
        }

        return false;
    }
}