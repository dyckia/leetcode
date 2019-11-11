/*
An intuitive way is to scan the matrix,
record the postion of the zeros we've encountered.
Based on our recorded coordinates, 
we set all their corresponding rows and cols to zeros.

The algorithm is inefficiency since if there are 
mutiple zeros in the same row or col, we need to 
keep resetting other numbers in that row or col to zeros.

Thus we can just store the row or col number instead 
which reduces the space to m+n.

O(1) space: modify input or build on output
We can further improve space by just modifying the first row and col as our marker/flag.
In this case we lose the information of the first row and col, thus we use two additional
variables indicating whether first row and col contains zero.
*/

class Solution {
    public void setZeroes(int[][] matrix) {

        boolean firRowHasZero = false;
        boolean firColHasZero = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    if (row == 0) firRowHasZero = true;
                    if (col == 0) firColHasZero = true;
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        // we don't want to erase our data in the fisrt row / col
        // so we'll start from 1
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) matrix[row][col] = 0;
            }
        }

        if (firRowHasZero) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[0][col] = 0;
            }
        }

        if (firColHasZero) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
    }

}

/*
Time: O(m*n)

Space: O(1)
*/