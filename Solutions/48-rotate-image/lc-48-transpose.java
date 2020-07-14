class Solution {
    
    public void rotate(int[][] matrix) {
        // to rotate an matrix
        // we can first transpose the matrix
        // and reverse every row 
        
        /* 
            origin    inverse   reverse
            1 2 3     1 4 7     7 4 1
            4 5 6     2 5 8     8 5 2
            7 8 9     3 6 9     9 6 3
        */
        
        inverse(matrix);
        for (int row = 0; row < matrix.length; row++) {
            reverse1(matrix[row]);
        }
        
    }
    
    // inverse a matrix in place
    private void inverse(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = row + 1; col < matrix[0].length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }
    
    // reverse a row in place
    private void reverse(int[] row) {
        for (int i = 0; i <= (row.length - 1) / 2; i++) {
            int temp = row[i];
            row[i] = row[row.length - 1 - i];
            row[row.length - 1 - i] = temp;
        }
    }
    
    // reverse a row using two pointers
    private void reverse1(int[] row) {
        int i = 0,
            j = row.length - 1;
        
        while (i < j) {
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            i++;
            j--;            
        }
    }
    
}

/*
Time: O(n^2)

Space: O(1)
*/