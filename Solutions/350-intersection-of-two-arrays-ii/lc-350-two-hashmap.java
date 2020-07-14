class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // num -> count
        Map<Integer, Integer> map1 = addToMap(nums1);
        Map<Integer, Integer> map2 = addToMap(nums2);
        
        int[] arr = new int[Math.min(nums1.length, nums2.length)];
        int i = 0;
        for (int num : map1.keySet()) {
            if (map2.containsKey(num)) {
                // get common count
                int count = Math.min(map1.get(num), map2.get(num));
                // add to arr
                for (int j = 0; j < count; j++) {
                    arr[i++] = num;
                }
            }
        }
        return Arrays.copyOf(arr, i);
    }
    
    private Map<Integer, Integer> addToMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n : nums) {
            int count = map.getOrDefault(n, 0);
            map.put(n, ++count);
        }
        
        return map;
    }
}

/*
Time: m + n

Space: m + n
*/