class Solution {
    public int maxSubArray(int[] nums) {
        // max of all substrings
        int maxGlobal = nums[0];
        // max of substrings ends at current index
        int maxCurrent = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            maxCurrent = (maxCurrent > 0) ? maxCurrent + nums[i] : nums[i];
            maxGlobal = Math.max(maxGlobal, maxCurrent);
        }
        
        return maxGlobal;
    }
}