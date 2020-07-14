class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used, cur, res);
        return res;
    }
    
    private void backtracking(int[] nums, boolean[] used, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == nums.length) {
            // must make a copy of cur list
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // that number has already been used
            if (used[i]) continue;
            
            cur.add(nums[i]);
            used[i] = true;
            backtracking(nums, used, cur, res);
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
        
        return;
    }
}