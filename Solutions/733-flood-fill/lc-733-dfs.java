class Solution {
    // if newColor == oldColor, do noting 
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        
        // newColor == oldColor, do noting
        if (oldColor == newColor) return image;
        dfs(image, sr, sc, newColor, oldColor);
        
        return image;
    }
    
    private void dfs(int[][] image, int r, int c, int newColor, int oldColor) {
        // out of boundary
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;
        // pixel is not oldColor, not fill
        if (image[r][c] != oldColor) return;
        
        // fill newColor
        image[r][c] = newColor;
        // check neighbors
        dfs(image, r - 1, c, newColor, oldColor);
        dfs(image, r + 1, c, newColor, oldColor);
        dfs(image, r, c - 1, newColor, oldColor);
        dfs(image, r, c + 1, newColor, oldColor);
        
        return;
    }
}

/*
Time: m*n

Space: m*n
*/