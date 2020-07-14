class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> path = new LinkedList<>();
        if (matrix.length == 0) return path;
        
        int rowMin = 0,
            rowMax = matrix.length - 1,
            colMin = 0,
            colMax = matrix[0].length - 1;
        int[] rowInc = {0, 1, 0, -1};  //row increment
        int[] colInc = {1, 0, -1, 0};
        int direction = 0;
        int curRow = 0;
        int curCol = 0;
                
        while(colMin <= colMax && rowMin <= rowMax) {
            while(curCol >= colMin && curCol <= colMax && curRow >= rowMin && curRow <= rowMax) {
                path.add(matrix[curRow][curCol]);
                curRow += rowInc[direction];
                curCol += colInc[direction];
            }

            if (curCol > colMax) {
                curCol--;
                rowMin++;
            } else if (curRow > rowMax) {
                curRow--;
                colMax--;
            } else if (curCol < colMin) {
                curCol++;
                rowMax--;
            } else if (curRow < rowMin) {
                curRow++;
                colMin++;
            }

            direction = (direction + 1) % 4;
            curRow += rowInc[direction];
            curCol += colInc[direction];
        }
        
        return path;
    }
}