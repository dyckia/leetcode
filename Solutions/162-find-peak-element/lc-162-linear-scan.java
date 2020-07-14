class Solution {
    

    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) return i;
        }

        // the array is in asending order, return last index
        return nums.length - 1;
    }
}

/*
Time: O(logn)

Space: O(1)
*/