class Solution {
    public int maxProduct(int[] nums) {
        // if an integer array contains no zeros
        // the max product subarray must include either one end or both
        // proof: 
        // 1. start > 0, end > 0, must include both
        // 2. start < 0, end > 0, must include both
        // 3. start > 0, end < 0 
        //    if product between [start - 1, end - 1] > 0, must include start
        //    if product between [start - 1, end - 1] < 0, must include end

        // if the array contains zeros
        // we can split the array into mutiple segments with no zeros

        int max = nums[0],
            n = nums.length,
            left = 0,
            right = 0;

        for (int i = 0; i < n; i++) {
            left = (left == 0 ? 1 : left) * nums[i];
            right = (right == 0 ? 1 : right) * nums[n - 1 - i];
            max = Math.max(max, Math.max(left, right));
        }

        return max;
    }
}

/*
Time: O(n)

Space: O(1)
*/