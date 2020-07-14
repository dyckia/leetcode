class Solution {
    public int orangesRotting(int[][] grid) {
        // bfs, change 1s to 2s
        // if freshCount == 0, return mins
        // if queue is empty and freshCount > 0, return -1
        int row = grid.length;
        int col = grid[0].length;
        int freshCount = 0;
        int mins = 0;
        Queue<Integer> rottens = new LinkedList<>();
        
        // scan the grid, put rotten orange in queue
        // and count fresh oranges
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) freshCount++;
                if (grid[i][j] == 2) rottens.offer(i * col + j);
            }
        }
        
        // bfs
        while (!rottens.isEmpty()) {
            // check whether there are fresh oranges left
            if (freshCount == 0) break;
            mins++;
            for (int n = rottens.size(); n > 0; n--) {
                int id = rottens.poll();
                int r = id / col;
                int c = id % col;
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    rottens.offer((r - 1) * col + c);
                    freshCount--;
                }
                if (r + 1 < row && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    rottens.offer((r + 1) * col + c);
                    freshCount--;
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    rottens.offer(r * col + c - 1);
                    freshCount--;
                }
                if (c + 1 < col && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    rottens.offer(r * col + c + 1);
                    freshCount--;
                }
            }
        }
        
        return freshCount == 0 ? mins : -1;
    }
}

/*
Time: m * n

Space: m * n


We can improve the space by using in-place BFS. 
Mark oranges to be visited in the next round as 3.
In each round, scan the whole grid.

Time: (m * n)^2

Space: 1
*/