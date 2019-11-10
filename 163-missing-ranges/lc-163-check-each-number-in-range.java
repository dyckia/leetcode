/*
Any number in missing range must be in [low, upper] but not in nums

Continue checking wether next number is in nums
*/

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        List<String> res = new ArrayList<>();

        // next number to check in nums
        int next = lower;

        for (int i = 0; i < nums.length; i++) {

            if (next == nums[i]) {
                next++;
            } else if (next < nums[i]) {
                res.add(formRange(next, nums[i] - 1));
                next = nums[i] + 1;
            } else {
                // nums[i] == nums[i - 1] continue our search
                continue;
            }
            
            // we can only reach here if next = MAX_VALUE + 1
            // which means we've already checked the last integer in the range
            if (next == Integer.MIN_VALUE) {return res;}
        }
        

        // handle nums[len - 1] to upper
        if (next <= upper) res.add(formRange(next, upper));
        
        return res;
    }
    
    private String formRange(int low, int high) {
        return low == high ? String.valueOf(low) : (low + "->" + high);
    }
}

/*
Time: O(n)

Space: O(1)
*/