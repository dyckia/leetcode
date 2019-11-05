class Solution {
    /*
        1 2 3 4 5 6 7 
        k = 3

        5 6 7 1 2 3 4

        reverse whole array
        reverse from 0 to k - 1
        reverse from k to end
    */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    // reverse an array from start to end (inclusive)
    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

/*
Time: O(n)

Space: O(1)
*/