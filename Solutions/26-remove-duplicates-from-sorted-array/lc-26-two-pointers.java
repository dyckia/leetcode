class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        int uniqueInd = 0;
        
        for (int i = 1; i < nums.length; i++) {
            // found unique number
            if (nums[uniqueInd] != nums[i]) {
                uniqueInd++;
                nums[uniqueInd] = nums[i];
            }
        }
        
        
        return uniqueInd + 1;
    }
}

/*
Time: O(n)

Space: O(1)
*/