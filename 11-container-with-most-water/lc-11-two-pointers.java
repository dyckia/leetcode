/* 
Given a container between 0 and n, 
the only way to increase the area of a container
is that the height of its boudary line increases,
which can only achieved by moving the shorter boudary inward
*/

class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int curArea = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, curArea);
            if (height[left] < height[right]) 
                left++;
            else 
                right--;
        } 
        
        return maxArea;
    }
}