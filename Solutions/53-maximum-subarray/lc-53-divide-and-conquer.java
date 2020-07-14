class Solution {
    public int maxSubArray(int[] nums) {        
        return helper(nums, 0, nums.length -1);
    }
    
    public int helper(int[] nums, int left, int right) {
        if (right <= left) return nums[left];
        
        int mid = (right+left) / 2;
        
        int maxLeft = helper(nums, left, mid-1);
        int maxCross = getMaxCross(nums, left, right, mid);
        int maxRight = helper(nums, mid+1, right);
        
        return Math.max(Math.max(maxLeft, maxCross), maxRight);
    }
    
    public int getMaxCross(int[] nums, int left, int right, int mid) {

        int maxLeft = 0; // if max left is less than 0, we'd rather not include it
        int maxRight = 0; 

        // maximum sum from mid to left
        int curSum = 0;
        for(int i = mid-1; i >= left; i--) {
            curSum += nums[i];
            maxLeft = Math.max(maxLeft, curSum);
        }

        // maximum sum from mid to right
        curSum = 0;
        for(int i = mid+1; i <= right; i++) {
            curSum += nums[i];
            maxRight = Math.max(maxRight, curSum);
        }

        return (nums[mid] + maxLeft + maxRight);
    }
    
}