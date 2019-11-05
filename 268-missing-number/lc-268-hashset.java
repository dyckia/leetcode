class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }

        int missN = 0;

        // to nums.length + 1 since one number is missing
        while (missN < nums.length + 1) {
            if (!numsSet.contains(missN)) return missN;
            missN++;
        }
        
        return missN;
    }
}

/*
Time: O(n)

Space: O(n)
*/
