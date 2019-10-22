class Solution {
    public int subarraySum(int[] nums, int k) {
        
        // calculate cummulative sum, sum[i] is the sum from 0 to i-1
        int[] sums = new int[nums.length+1];
        sums[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end < nums.length + 1; end++) {
                int sum = sums[end] - sums[start];
                if (sum == k) count++;
            }
        }
        
        return count;
    }
}

/*
Time: O(n^2)

Space: O(n)
*/