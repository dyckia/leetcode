class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int row = grid.length, col = grid[0].length;
        int res = 0;
        // scan the map
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    bfs(grid, i, j);
                }
            }
        }
        
        return res;
    }
    
    private void bfs(char[][] grid, int r, int c) {
        grid[r][c] = '0';
        int row = grid.length, col = grid[0].length;
        Queue<Integer> neighbors = new LinkedList<>();
        neighbors.offer(r * col + c);
        
        while (!neighbors.isEmpty()) {
            int id = neighbors.poll();
            int i = id / col, j = id % col;
            if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                // must mark visited immediately once added to queue 
                neighbors.offer((i - 1) * col + j);
                grid[i - 1][j] = '0';
            }
            if (i + 1 < row && grid[i + 1][j] == '1') {
                neighbors.offer((i + 1) * col + j);
                grid[i + 1][j] = '0';
            }
            if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                neighbors.offer(i * col + (j - 1));
                grid[i][j - 1] = '0';
            }
            if (j + 1 < col && grid[i][j + 1] == '1') {
                neighbors.offer(i * col + (j + 1));
                grid[i][j + 1] = '0';
            }
        }
        
        return;
    }
}

/*
Time: row * col

Space: min(row, col) queue size
*/