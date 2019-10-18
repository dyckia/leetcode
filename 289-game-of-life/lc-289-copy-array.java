class Solution {
    public void gameOfLife(int[][] board) {
        
        // make a copy of original board
        int[][] boardCopy = copyArray(board);
        
        // for each cell, calculate its live neighbor's count
        for (int row = 0; row <= board.length - 1; row++) {
            for (int col = 0; col <= board[0].length - 1; col++) {
                int count = countNeighbors(boardCopy, row, col);
                // update the cell based on the rule
                updateCell(board, row, col, count);
            }
        }
        
    }
    
    
    private int[][] copyArray(int[][] board) {
        // create a new array of the same size
        int[][] copy = new int[board.length][board[0].length];
        for (int row = 0; row <= board.length - 1; row++) {
            // can be replaced with System.arraycopy
            for (int col = 0; col <= board[0].length - 1; col++) {
                // copy each cell value
                copy[row][col] = board[row][col];
            }
        }
        
        return copy;
    }
    
    private int countNeighbors(int[][] boardCopy, int row, int col) {
        int count = 0;
        int up = (row == 0) ? 0 : row - 1;
        int down = (row == boardCopy.length - 1) ? boardCopy.length - 1 : row + 1;
        int left = (col == 0) ? 0 : col - 1;
        int right = (col == boardCopy[0].length - 1) ? boardCopy[0].length - 1 : col + 1;
        for (int i = up; i <= down; i++) {
            for (int j = left; j <= right; j++) {
                count += boardCopy[i][j];
            }
        }
        return count - boardCopy[row][col];
    }
    
    private void updateCell(int[][] board, int row, int col, int count) {
        if (board[row][col] == 0) {
            if (count == 3) board[row][col] = 1;
        } else {
            if (count < 2 || count > 3) board[row][col] = 0;
        }
    }
}