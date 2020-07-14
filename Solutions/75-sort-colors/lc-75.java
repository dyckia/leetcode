class Solution {
    /*
        Use three pointers left, right and cur
        left is the end index of 0s
        right is the first index of 2s

        while we travel through the array, it loos like
              l       c  unsorted r
        0 0 0 0 1 1 1 2 0 1 2 1 1 2 2 2 2

        if c == 2 swap c with r + 1, r++
        if c == 0 swap c with l + 1, l++ c++(since the new number of c could not be 2)
        if c == 1 do nothing c++
    */
    
    public void sortColors(int[] nums) {
        // bound for 0 and 2
        int left = -1,
            right = nums.length,
            cur = 0;
        
        while(cur < right) {
            if (nums[cur] == 0) {
                swap(nums, cur, left+1);
                left++;
                cur++;
            } else if (nums[cur] == 2) {
                swap(nums, cur, right-1);
                right--;
            } else {
                // nums[cur] == 1
                cur++;
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*
Time: O(n)
one pass of the array

Space: O(1)
*/