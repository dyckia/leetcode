class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // for each element in the nums, we have two options
        // either include it or exclude it
        // we can iteritively build the combinations set
        // by adding cur element or leave it as it be
        
        List<List<Integer>> combinations = new ArrayList<>();
        combinations.add(new ArrayList<Integer>());
        
        for (int num : nums) {
            int n = combinations.size();
            for (int i = 0; i < n; i++) {
                List<Integer> newSet = new ArrayList<>(combinations.get(i));
                newSet.add(num);
                combinations.add(newSet);
            }
        }
        
        return combinations;
    }
    
}