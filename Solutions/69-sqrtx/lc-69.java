class Solution {
    public int mySqrt(int x) {
        // 4 => 2 (2^2 = 4)
        // 8 => 2 (2^2 = 4)
        // 9 => 3 (3^2 = 9)
        
        // the sqrts of all integer numbers in [4, 9) are 2
        
        // find the largest integer k so that k^2 <= x
        // or find the smallest integer k so that k^2 > x (ans is k - 1)
        
        // search that number using binary search
        return binarySearch(x, 1, x/2 + 2) - 1;
        
    }
    
    // search smallest integer k that k^2 >= x in range [left, right)
    private int binarySearch(int target, int left, int right) {
        
        while (left < right) {
            // use right - left to avoid overflow
            int mid = left + (right - left) / 2;
            if (Math.pow(mid, 2) <= target) {
                // ans is in the right half
                left = mid + 1;
            } else {
                // ans is in the left half
                right = mid;
            }
        }
        
        return left;
    }
}