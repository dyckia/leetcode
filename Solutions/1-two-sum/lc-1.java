class Solution {
    public int[] twoSum(int[] nums, int target) {
        // hashmap would store the <theOtherNum, indexOfCurrentNum>
        HashMap<Integer, Integer> theOtherNums = new HashMap<>();
        
        int[] result = new int[2];
        for (int i=0; i<nums.length; i++) {
            if (theOtherNums.containsKey(nums[i])) {
                result[0] = theOtherNums.get(nums[i]);
                result[1] = i;
                return result;
            }
            theOtherNums.put((target - nums[i]), i);
        }
            
        return result;
    }
}