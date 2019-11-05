class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        int missN = 0;

        // to nums.length + 1 since one number is missing
        while (missN < nums.length) {
            if (missN != nums[missN]) return missN;
            missN++;
        }

        // the missing number is the last one
        return nums.length;

    }
}

/*
Time: O(nlogn)

Space: O(1)
*/
