/*
if nums[i] + 1 != nums[i] we find a missing range
notice nums[i] could be equal to nums[i] + 1

we also need to check the range [low, nums[0]] and [nums[len - 1], upper]
*/

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        List<String> res = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            res.add(formRange(lower, upper));
            return res;
        }

        // handle beginning range
        if (nums[0] > lower) {
            res.add(formRange(lower, nums[0] - 1));
        }

        for (int i = 0; i < nums.length - 1; i++) {
            // found a missing range
            // couldn't use nums[i] + 1 < nums[i + 1] since nums[i] + 1 could overflow
            if (nums[i] + 1 != nums[i + 1] && nums[i] < nums[i + 1]) {
                res.add(formRange(nums[i] + 1, nums[i + 1] - 1));
            }
        }

        // handle ending range
        if (nums[nums.length - 1] < upper) {
            res.add(formRange(nums[nums.length - 1] + 1, upper));
        }
        
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