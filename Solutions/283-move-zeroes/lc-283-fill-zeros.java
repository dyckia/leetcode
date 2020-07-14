class Solution {
    public void moveZeroes(int[] nums) {
        // n is the number of non-zero elements
        int n = 0;
        
        // scan nums, put non-zero elements in the front
        for (int num : nums) {
            if (num != 0) {
                nums[n] = num;
                n++;
            }
        }
        
        // starting from the last non-zero element, replace all elements after that with zeros
        for (int i = n; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}