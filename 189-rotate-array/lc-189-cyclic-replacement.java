class Solution {
    /*
        1 2 3 4 5 6 7 
        len = 7
        k = 3
        5 6 7 1 2 3 4

        each step we move nums[i] to its final place nums[i + k]
        we need to move a total nums.length elements

        - Use count as final end condition
        - If return to start index, start from start + 1
        (if start + 1 is alreay replaced, then every time we
        cycle through array, it should continuously + 1 until 
        we've replaced all the elements)
    */

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int start = 0,
            count = 0,
            cur = start,
            prevValue = nums[cur];
        while(count < nums.length) {
            int next = (cur + k) % nums.length;
            int temp = nums[next];
            nums[next] = prevValue;
            prevValue = temp;
            cur = next;
            if (cur == start) {
                start++;
                // to prevent preValue out of index boundary
                if (start == nums.length) break; 
                cur = start;
                prevValue = nums[cur];
            }
            count++;
        }
    }
}

/*
Time: O(n)

Space: O(1)
*/