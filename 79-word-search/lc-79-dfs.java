class Solution {
    private boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
        // board is empty
        if (board.length == 0) return false;
        
        // word is empty
            
        // start from every char in the board, do dfs search
        visited = new boolean[board.length][board[0].length];
            
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (matchWord(board, i, j, word, 0)) return true;
            }
        }
        
        return false;
    }
    
    private boolean matchWord(char[][] board, int row, int col, String word, int ind) {
        
        // no char left to check, this has to be the first condition to check
        if (ind == word.length()) return true;
        
        // reach boundary
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        
        // check at index ind if not visited
        if (!visited[row][col] && board[row][col] == word.charAt(ind)) {
            visited[row][col] = true;
            boolean isSuffixMatch = matchWord(board, row - 1, col, word, ind + 1) ||
                                    matchWord(board, row + 1, col, word, ind + 1) ||
                                    matchWord(board, row, col - 1, word, ind + 1) ||
                                    matchWord(board, row, col + 1, word, ind + 1);
            if (isSuffixMatch) {
                return true;
            } else {
                // set cur char as unvisited
                visited[row][col] = false;
            }
        }
        
        return false;
    }
}

/*
Time: O(m*n*l*4)
for exist func, m*n (m and n is board's row and col nums)
for matchWord func, l*4 (l is the length of the word)

Space: O(m*n)
for maintaining the boolean array
if modify input is allowed, one can further improve the space complexity to O(1) 
by changing the char to an non-printing character to mark as visited
*/