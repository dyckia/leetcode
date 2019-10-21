/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // if v5 is bad then all versions after 5 will also be bad
        // find the smallest version k so that isBadVersion(k) returns true
        // use binary search to find such smallest version
        
        int left = 1;
        int right = n;
        
        // binary search in range [left, right]
        while (left < right) {
            // use (right - left) to avoid int overflow
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                // first bad version must be in the left half
                right = mid;
            } else {
                // in the right half
                left = mid + 1;
            }
        }
        
        return left;
    }
}