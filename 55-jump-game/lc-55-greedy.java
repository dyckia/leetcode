class Solution {
    public boolean canJump(int[] nums) {
        // we start from the end of the array
        // for each number, we consider whether it
        // can reach our leftmost good index (the index that can reach the end)
        // if so, current index becomes the leftmost good index
        
        int leftMostInd = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= leftMostInd) {
                leftMostInd = i;
            }
        }

        return leftMostInd == 0;
    }
}

/*
Time: O(n)


Space: O(1)
*/