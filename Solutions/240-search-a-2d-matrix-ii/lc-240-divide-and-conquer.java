// the top left number is the smallest among all numbers
// the bottom right number is the largest among all numbers
// divide the matrix into four quadrants until matrix is 1x1 or empty

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        // matrix may be null or empty
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        return searchMatrix(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    private boolean searchMatrix(int[][] matrix, int target, int top, int bottom, int left, int right) {
        // base case: empty matrix
        if (left > right || top > bottom)
            return false;
        // base case: 11x1 matrix
        if (left == right && top == bottom)
            return matrix[top][left] == target;

        if (matrix[top][left] > target || matrix[bottom][right] < target)
            return false;

        if (matrix[top][left] == target || matrix[bottom][right] == target)
            return true;

        // might overflow
        int midRow = (top + bottom) / 2;
        int midCol = (left + right) / 2;

        return (searchMatrix(matrix, target, top, midRow, left, midCol)
                || searchMatrix(matrix, target, midRow + 1, bottom, left, midCol)
                || searchMatrix(matrix, target, top, midRow, midCol + 1, right)
                || searchMatrix(matrix, target, midRow + 1, bottom, midCol + 1, right));
    }
}