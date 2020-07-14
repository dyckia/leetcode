class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        // sort the array to save the memory space of a HashMap
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }

    private List<List<Integer>> kSum(int[] nums, int target, int k, int start) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        if (start > len - 1) return res;
        
        if (k == 2) {
            // problem is reduced to two sum
            res = twoSum(nums, target, start);
        } else {
            // end condition doesn't need to be len - 1 
            for (int cur = start; cur <= len - k; cur++) {
                // reduce the problem to k-1 sum by selecting cur element
                List<List<Integer>> solutions = kSum(nums, target - nums[cur], k - 1, cur + 1);
                if (solutions != null) {
                    // outstanding elements can form possible solutions
                    // add cur element to each solution
                    for (List<Integer> solution : solutions) {
                        solution.add(nums[cur]);
                        res.add(solution);
                    }
                }
                // avoid duplicates
                while (cur < len - 1 && nums[cur+1] == nums[cur]) cur++;
            }
        }

        return res;
    }

    // use two pointers to find all possible pairs
    private List<List<Integer>> twoSum(int[] nums, int target, int start) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        if (start > len - 1) return res;

        int left = start,
            right = len - 1;
            
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                // found a pair
                List<Integer> newPair = new ArrayList<>();
                newPair.add(nums[left]);
                newPair.add(nums[right]);
                res.add(newPair);
                // keep searching
                left++;
                right--;
                // avoid duplicates
                while (left < right && nums[left - 1] == nums[left]) left++;
                while (left < right && nums[right + 1] == nums[right]) right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}

/*
Time O(n^(3))
nlogn for sorting
n^(k-2) for kSum
n for 2Sum
total nlogn + n^(k-2)*n

Space O(1)
*/