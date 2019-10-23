class Solution {
    public void nextPermutation(int[] nums) {
        
        // start from the end of nums
        // find the first element nums[i] such that nums[i-1] < nums[i]
        int i = nums.length - 1;
        while(i > 0 && nums[i-1] >= nums[i]) {
            i--;
        }
        
        // swap nums[i-1] and element nums[k] which is the first number in [i+1:end] that is greater than nums[i-1]
        if (i != 0) {
            int j = i - 1;
            int k = i;
            // note the right part must be in descending order
            while (k < nums.length - 1 && nums[j] < nums[k+1]) {
                k++;
            }
            
            swap(nums, j, k);
        }

        // reverse nums in [k, end]
        reverse(nums, i);
    }
    
    private void swap(int[] nums, int fir, int sec) {
        int temp = nums[fir];
        nums[fir] = nums[sec];
        nums[sec] = temp;
    }
    
    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}