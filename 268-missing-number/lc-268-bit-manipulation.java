class Solution {
    /*
        any number XOR with 0 is itself
        any number XOR with itself is 0

        INDEX   0    1    2    3
        VALUE   0    1    3    4
        missing = 4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)
                = (4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2
                = 0∧0∧0∧0∧2
                = 2
    */


    public int missingNumber(int[] nums) {
        int missing = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            missing = missing ^ i ^ nums[i];
        }

        return missing;
    }
}

/*
Time: O(n)

Space: O(1)
*/
