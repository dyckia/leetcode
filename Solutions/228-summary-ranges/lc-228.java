class Solution {
    public List<String> summaryRanges(int[] nums) {
        // as the array is already sorted
        // we can just scan through the array and check 
        // whether the current element is equal to high + 1
        // if not, create a new range
        
        List<String> summary = new ArrayList<>();
        
        for (int lowInd = 0; lowInd < nums.length; lowInd++) {
            int highInd = lowInd;
            while(highInd + 1 < nums.length && nums[highInd + 1] == nums[highInd] + 1) {
                highInd++;
            }
            if (highInd == lowInd) {
                summary.add("" + nums[lowInd]);
            } else {
                summary.add(nums[lowInd] + "->" + nums[highInd]);
            }
            lowInd = highInd;
        }
        
        return summary;
    }
}