class Solution {
    public int[] pourWater(int[] heights, int V, int K) {
        
        // once a droplet finds its place, we can just treat it as a normal height
        // the problem becomes for each drop at K,
        // find its eventual place and update the elevation map
        
        for (int i = V; i > 0; i--) {
            int ind = getFinalPosition(heights, K);
            heights[ind]++;
        }
        
        return heights;
    }
    
    private int getFinalPosition(int[] heights, int K) {
        
        // try move left
        int finalIndex = tryMove(heights, K, -1);
        
        if (finalIndex >= 0) return finalIndex;
        
        // try move right
        finalIndex = tryMove(heights, K, 1);
        
        if (finalIndex >= 0) return finalIndex;
        
        // stay at current position
        return K;
    }
    
    private int tryMove(int[] heights, int K, int direction) {
        int ind = -1;
        int cur = K + direction;
        
        while(cur >=0 && cur < heights.length && heights[cur] <= heights[K]) {
            // if a position lower than K is found, record that position
            if (heights[cur] < heights[K]) {
                ind = cur;
                K = cur;
            }
            cur += direction;
        }
        
        return ind;
    }
    
}

/*
Time: O(V * height.length)

Space: O(1)
*/