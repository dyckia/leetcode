class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, (right - left) * minHeight);
            while (height[left] <= minHeight && left < right) left++;
            while (height[right] <= minHeight && left < right) right--;
        } 
        
        return maxArea;
    }
}