class TicTacToe {
    int[] r;
    int[] c;
    // there is only one diagonal in each direction
    int diagonal;
    int antiDiagonal;
    int size;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        r = new int[n];
        c = new int[n];
        diagonal = 0;
        antiDiagonal = 0;
        size = n;
    }
    
    // every move is O(1) time
    public int move(int row, int col, int player) {
        // game wins when a player fills the whole row, col, diagonal or antigonal
        // keep track of the sum of each row, col and diagonal
        // 1 for player 1, -1 for player 2
        int n = (player == 1) ? 1 : -1;
        r[row] += n;
        c[col] += n;
        // on diagonal
        if (row == col) diagonal += n;
        if (row + col == size - 1) antiDiagonal += n;
        
        if (Math.abs(r[row]) == size || 
            Math.abs(c[col]) == size ||
            Math.abs(diagonal) == size ||
            Math.abs(antiDiagonal) == size) {
            // the one who moves must win
            return player;
        }
        
        return 0;
    }
}

