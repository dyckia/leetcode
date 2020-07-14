class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seenNums = new HashSet<>();
        
        for (int num : nums) {
            if (seenNums.contains(num)) return true;
            seenNums.add(num);
        }
        
        return false;
    }
}

/*
Time: O(n)

Space: O(n)
*/