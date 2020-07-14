class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // make sure nums1.length is always less than nums2.length
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        
        // counts for nums1
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            int count = map.getOrDefault(n, 0);
            map.put(n, ++count);
        }
        
        int[] arr = new int[nums1.length];
        int i = 0;
        // check each number in nums2
        for (int n : nums2) {
            int count = map.getOrDefault(n, 0);
            if (count > 0) {
                arr[i++] = n;
                // reduce count by 1
                map.put(n, --count);
            }
        }
        return Arrays.copyOf(arr, i);
    }
}

/*
Time: m + n

Space: min(m, n)
*/