class Solution {
    // edge case: {}
    // edge case: {1}
    // normal case: 4,5,6,7,0,1,2
    
    public int search(int[] nums, int target) {
        
        if (nums.length == 0) return -1;
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) {
                // [left:mid] is non-rotated
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // if the first part is roated, second part must be non-rotated
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
}