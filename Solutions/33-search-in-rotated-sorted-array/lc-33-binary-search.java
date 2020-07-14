class Solution {
    // edge case: {}
    // edge case: {1}
    // normal case: 4,5,6,7,0,1,2
    
    public int search(int[] nums, int target) {
        
        if (nums.length == 0) return -1;
        
        int index = -1;
        // find pivot point
        int pivot = findPivot(nums, target);
        
        // find target in two segments through binary search
        if (target >= nums[0] && target <= nums[pivot]) {
            index = binarySearch(nums, target, 0, pivot);
        }
        
        // must check the existance of second segment
        if (pivot+1 <= nums.length-1 && target >= nums[pivot+1] && target <= nums[nums.length - 1]) {
            index = binarySearch(nums, target, pivot+1, nums.length-1);
        }
        
        // return -1 if can't find in both segments
        return index;
    }
    
    // time: log(n), space: O(1)
    private int findPivot(int[] nums, int target) {
        // one element
        if (nums.length == 1) return 0;
        
        // pivot point is the one that its next element is smaller than itself
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = (left + right) / 2; // mid + 1 must exist
            if (nums[mid] > nums[mid + 1]) return mid;
            // if arr[left] < arr[right] we can say there is no pivot in this segment
            if (nums[left] < nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        return nums.length - 1;  // no pivot
    }
    
    // time: log(n), space: O(1)
    private int binarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        
        // return -1 if can't find that target in the segment 
        return -1;
    }
}

/*
Time: O(log(n))
Space: O(1)
*/