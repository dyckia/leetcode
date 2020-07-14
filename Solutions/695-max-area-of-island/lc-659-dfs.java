class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1 && !visited[row][col]) {
                    int area = getArea(grid, row, col, visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int getArea(int[][]grid, int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        int area = 1;

        // go up
        if (row - 1 >= 0 && grid[row - 1][col] == 1 && !visited[row - 1][col])
            area += getArea(grid, row - 1, col, visited);

        // go down
        if (row + 1 < grid.length && grid[row + 1][col] == 1 && !visited[row + 1][col])
            area += getArea(grid, row + 1, col, visited);

        // go left
        if (col - 1 >= 0 && grid[row][col - 1] == 1 && !visited[row][col - 1])
            area += getArea(grid, row, col - 1, visited);

        // go right 
        if (col + 1 < grid[0].length && grid[row][col + 1] == 1 && !visited[row][col + 1])
            area += getArea(grid, row, col + 1, visited);
        
        return area;
    }

}

/*
Time: O(row*col)

Space: O(row*col)
For visited boolean as well as call stack
*/