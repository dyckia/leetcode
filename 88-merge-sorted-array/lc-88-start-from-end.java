class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // to avoid data loss, we can start from the end of array1, namely m+n-1,
        // and keep inserting the larger element of the two ends
        int end = m + n - 1;
        m -= 1;
        n -= 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] >= nums2[n]) {
                nums1[end] = nums1[m];
                m--;
            } else {
                nums1[end] = nums2[n];
                n--;
            }
            end--;
        }
        // since we're merging nums2 into nums1
        // we only need to handle the case that nums2 has remaining elements
        while (n >= 0) {
            nums1[end] = nums2[n];
            n--;
            end--;
        }
    }
}