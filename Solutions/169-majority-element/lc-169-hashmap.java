class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int occurance = count.getOrDefault(nums[i], 0) + 1;
            count.put(nums[i], occurance);
            if (occurance > nums.length/2) {
                return nums[i];
            }
        }

        return -1;
    }
}

/*
Time: O(n)
Space: O(n)
*/