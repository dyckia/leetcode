class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] {-1, -1};
        
        int lBound = binarySearch(nums, target, true);
        
        // target does not exist in nums
        if (lBound == -1) return new int[] {-1, -1};

        int rBound = binarySearch(nums, target + 1, false);

        // target range reaches to the end of nums
        if (rBound == -1) return new int[] {lBound, nums.length - 1};

        return new int[] {lBound, rBound - 1};
    }

    // return the first index which nums[i] == target or nums[i] >= target
    private int binarySearch(int[] nums, int target, boolean equalToTarget) {
        int left = 0,
            right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // must be in the left half
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (equalToTarget) return (nums[left] == target) ? left : -1;
        
        return nums[left] >= target ? left : -1;
    }
}
