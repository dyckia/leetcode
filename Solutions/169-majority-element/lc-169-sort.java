class Solution {
    public int majorityElement(int[] nums) {
        /* 
        if we sort the array 
        the majority element must be the n/2 element
        */
        
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}