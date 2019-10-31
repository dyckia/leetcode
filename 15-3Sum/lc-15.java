class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
          we can convert this problem to a two sum prblem by fixing one element
          we loop through the array, assume the selected element to be in the triplet
          check whether the assumption is true by calculating the sum of the rest elements
          to save memory space of a HashMap, we can sort the in advance
        */
        List<List<Integer>> results = new LinkedList<>();
        Arrays.sort(nums);
        // we can skip the last two since the number of rest elements is not enough to form a triplet
        for (int i = 0; i < nums.length - 2; i++) {
            // skip duplicated elements
            if (i!=0 && nums[i] == nums[i-1]) continue;
            
            int left = i + 1;
            int right = nums.length -1;
            int target = 0 - nums[i];
            while (left < right) {
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // skip duplicated elements
                    while (left < right && nums[left+1] == nums[left]) left++;
                    while (left < right && nums[right-1] == nums[right]) right --;
                    left++;
                    right--;
                }
            }
        }
        
        return results;
    }
}
