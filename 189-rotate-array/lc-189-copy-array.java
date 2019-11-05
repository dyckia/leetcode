class Solution {
    public void rotate(int[] nums, int k) {
        // if k >= nums.length
        k = k % nums.length;
        if (k == 0) return;

        // make an copy of nums
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            
            // the first element now becomes the i + k element
            nums[(i + k) % nums.length] = copy[i];
        }
        
        return;
    }
}

/*
Time: O(n)

Space: O(n)
*/