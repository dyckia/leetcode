class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // sort the array so any duplicates will be next to each other
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtracking(nums, used, cur, res);
        return res;
    }
     
    private void backtracking(int[] nums, boolean[] used, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == nums.length) {
            // must make a copy of current list
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            // to avoid duplicated permutations
            // for duplicated numbers, if its previous number hasn't been used, skip this number
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            
            cur.add(nums[i]);
            used[i] = true;
            backtracking(nums, used, cur, res);
            cur.remove(cur.size() - 1);
            used[i] = false; 
        }
        
        return;
    }
}

/*
Time: n!

Space: n
*/