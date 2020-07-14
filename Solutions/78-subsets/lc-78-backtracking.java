class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // find all the combinations of nums
        
        List<List<Integer>> combinations = new ArrayList<>();
        
        addCombinations(nums, 0, new ArrayList<Integer>(), combinations);
        
        return combinations;
    }
    
    private void addCombinations(int[] nums, int start, List<Integer> curSet, List<List<Integer>> combinations) {
        combinations.add(new ArrayList<Integer>(curSet));
        
        // for each element in nums, we consider two subsets
        // one contains nums[i], one does not contain nums[i] 
        for (int i = start; i < nums.length; i++) {
            curSet.add(nums[i]);
            addCombinations(nums, i + 1, curSet, combinations);
            curSet.remove(curSet.size() - 1);
        }
        
        return;
    }
    
}