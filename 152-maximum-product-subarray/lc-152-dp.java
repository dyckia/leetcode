class Solution {
    public int maxProduct(int[] nums) {
        // while we loop through the nums
        // we consider all possible subarries ends at current element i
        // the max product could only come from three places
        // maxProduct(i-1) * nums[i]
        // minProduct(i-1) * nums[i]  e.g. -3*-2
        // nums[i]  e.g. max = 0, min = 0, nums[i] = 3

        int max = nums[0],
            maxUpToCur = nums[0],
            minUpToCur = nums[0];

        for (int i = 1; i < nums.length; i++) {
            
            // must store prev value or we will compare while changing the value
            int maxUpToPrev = maxUpToCur,
                minUpToPrev = minUpToCur;
            
            maxUpToCur = Math.max(nums[i], Math.max(maxUpToPrev * nums[i], minUpToPrev * nums[i]));
            minUpToCur = Math.min(nums[i], Math.min(maxUpToPrev * nums[i], minUpToPrev * nums[i]));
            max = Math.max(max, maxUpToCur);
        }

        return max;
    }
}

/*
Time: O(n)

Space: O(1)
*/