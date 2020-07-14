class Solution {
    // since 1 <= a[i] <= n
    // if there is no number that appears twice
    // we should see every number between 1 and n exact once

    // since the value is always within (1, n)
    // it is easy to associate the value with the indices

    // since we want to do it with no extra space
    // it is easy to think either utilize the input space or output space

    // use sign as indicator whether we've visited an element of that value or not
    // while we iterate through the array
    // we treat the value of the element we're visiting as an index
    // we negate the value of that corrisponding index
    // if we try to negate a negative number, that means we've already visited
    // an element with that value before

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // use the value as an index
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                // we've visited an element of the same value before
                res.add(Math.abs(nums[i]));
            }
            nums[index] = -nums[index];
        }

        return res;
    }
}