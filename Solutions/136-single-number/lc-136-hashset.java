class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;

        for (int i : nums) {
            if (set.contains(i)) {
                // subtract the duplicate number
                ans -= i;
            } else {
                set.add(i);
                ans += i;
            }
        }
        
        return ans;
    }
}