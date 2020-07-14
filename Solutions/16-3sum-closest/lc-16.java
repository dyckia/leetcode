class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        // initial value
        int closestSum = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i <= nums.length - 3; i++) {
            int temp = twoSumClosest(nums, target - nums[i], i + 1) + nums[i];
            if (temp == target) return temp;
            closestSum = Math.abs(temp - target) < Math.abs(closestSum - target) ? temp : closestSum;
        }
        
        return closestSum;
    }
    
    private int twoSumClosest(int[] nums, int target, int start) {
        int left = start,
            right = nums.length - 1;
        
        int closestSum = nums[start] + nums[start + 1];
        
        while (left < right) {
            int temp = nums[left] + nums[right];
            closestSum = Math.abs(temp - target) < Math.abs(closestSum - target) ? temp : closestSum;
            if (temp < target) {
                left++;
            } else if (temp > target) {
                right--;
            } else {
                return closestSum;
            }
        }
        
        return closestSum;
    }
}

/*
Time: O(n^2)

Space: O(1)
*/