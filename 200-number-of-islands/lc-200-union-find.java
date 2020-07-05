class Solution {
    class UnionFindSet {
        int[] parents;
        int[] ranks;
        int count;
        
        public UnionFindSet(char[][] grid) {
            int row = grid.length, col = grid[0].length;
            parents = new int[row * col];
            ranks = new int[row * col];
            
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    parents[i * col + j] = i * col + j;
                    // ranks[i * col + j] = 0;
                    if (grid[i][j] == '1') count++;
                }
            }
        }
        
        public int findParent(int i) {
            // path compression
            if (i != parents[i]) parents[i] = findParent(parents[i]);
            return parents[i];
        }
        
        public boolean union(int i, int j) {
            int pi = findParent(i), pj = findParent(j);
            if (pi == pj) return false;
            
            // union by rank
            if (ranks[pi] < ranks[pj])
                parents[pi] = pj;
            else if (ranks[pi] > ranks[pj])
                parents[pj] = pi;
            else {
                parents[pi] = pj;
                ranks[pj] += 1;
            }
            count--;
            return true;
        }
        
        public int getCount() {
            return count;
        }
        
    }
    
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        UnionFindSet ufSet = new UnionFindSet(grid);
        int row = grid.length, col = grid[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') continue;
                grid[i][j] = '0';
                // if its neighbor is land union with the center
                if (i - 1 > 0 && grid[i - 1][j] == '1')
                    ufSet.union(i * col + j, (i - 1) * col + j);
                if (i + 1 < row && grid[i + 1][j] == '1')
                    ufSet.union(i * col + j, (i + 1) * col + j);
                if (j - 1 > 0 && grid[i][j - 1] == '1')
                    ufSet.union(i * col + j, i * col + j - 1);
                if (j + 1 < col && grid[i][j + 1] == '1')
                    ufSet.union(i * col + j, i * col + j + 1);
            }
        }
        
        return ufSet.getCount();
    }   
}