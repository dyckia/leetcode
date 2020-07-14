class Solution {
    public void gameOfLife(int[][] board) {
        
        /*
        instead of making a copy of the original board
        we can use dummy values to denote the previous state
         cur    origin      actual
         0      prev 0      now 0
         1      prev 1      now 1
        -1      prev 0      now 1
         2      prev 1      now 0
        */
        
        // for each cell, calculate its live neighbor's count
        for (int row = 0; row <= board.length - 1; row++) {
            for (int col = 0; col <= board[0].length - 1; col++) {
                int count = countNeighbors(board, row, col);
                // update the cell based on the rule
                updateCell(board, row, col, count);
            }
        }
        
        // replace dummy with 0 or 1
        replaceValue(board);
    }
    
    private int countNeighbors(int[][] board, int row, int col) {
        int count = 0;
        int up = (row == 0) ? 0 : row - 1;
        int down = (row == board.length - 1) ? board.length - 1 : row + 1;
        int left = (col == 0) ? 0 : col - 1;
        int right = (col == board[0].length - 1) ? board[0].length - 1 : col + 1;
        for (int i = up; i <= down; i++) {
            for (int j = left; j <= right; j++) {
                // current value > 0 means that prev value was 1
                count += (board[i][j] > 0) ? 1 : 0;
            }
        }
        count -= (board[row][col] > 0) ? 1 : 0;
        return count;
    }
    
    private void updateCell(int[][] board, int row, int col, int count) {
        if (board[row][col] == 0) {
            // prev 0 now 1
            if (count == 3) board[row][col] = -1;
        } else {
            // prev 1 now 0
            if (count < 2 || count > 3) board[row][col] = 2;
        }
    }
    
    private void replaceValue(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) board[i][j] = 1;
                if (board[i][j] == 2) board[i][j] = 0;
            }
        }
    }
}