class Solution {
    public int maxArea(int[] height) {
        
        return maxArea(height, 0, height.length - 1);
    }
    
    private int maxArea(int[] height, int left, int right) {
        if (left == right) return 0;
        
        int curArea;
        
        if (height[left] < height[right]) {
            curArea = (right - left) * height[left];
            return Math.max(curArea, maxArea(height, left + 1, right));
        } else {
            curArea = (right - left) * height[right];
            return Math.max(curArea, maxArea(height, left, right - 1));
        }
        
    }
}