class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // make sure nums1.length is always less than nums2.length
        if (nums1.length > nums2.length) return intersect(nums2, nums1);
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int[] arr = new int[nums1.length];
        // i -> nums1, j-> nums2, k -> arr
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                // nums[i] == nums[j]
                arr[k++] = nums1[i];
                i++;
                j++;
            }
        }
        
        return Arrays.copyOf(arr, k);
    }
}