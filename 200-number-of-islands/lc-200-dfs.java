class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int row = grid.length, col = grid[0].length;
        int res = 0;
        // scan the map
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int r, int c) {
        // out of boundary
        if (r < 0 || r > grid.length - 1 || c < 0 || c > grid[0].length - 1)
            return;
        // visited or sea
        if (grid[r][c] == '0')
            return;

        grid[r][c] = '0';
        // up, down, left, right
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
        
        return;
    }
}