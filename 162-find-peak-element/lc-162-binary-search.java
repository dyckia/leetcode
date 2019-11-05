class Solution {
    /*
        Use binary search to find peak element
        for each search, we make sure that the boundary element in our new search scope
        is always larger than its neighbor outside the boundary
        
        a [b c d e] f
        b > a, e > f
        
        a [b c] d
        in the final step, since nums[i] != nums[i+1]
        the peak must be the number which is greater
    */
    
    public int findPeakElement(int[] nums) {
        int left = 0,
            right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}