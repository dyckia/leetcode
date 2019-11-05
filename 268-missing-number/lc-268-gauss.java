class Solution {
    /*
        compute the total sum from 0 to nums.length
        the missing number is the sum[0, nums.length] - sum(nums)
    */


    public int missingNumber(int[] nums) {
        int expectedSum = (0 + nums.length) * (nums.length + 1) / 2;
        int acutalSum = 0;
        for (int num : nums) acutalSum += num;

        return expectedSum - acutalSum;
    }
}

/*
Time: O(n)

Space: O(1)
*/
