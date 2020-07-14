class Solution {
    // if there are duplicates in an array
    // then after sorting, the duplicates must be next to each other
    
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        
        return false;
    }
}

/*
Time: O(nlogn)

Space: O(1)
*/