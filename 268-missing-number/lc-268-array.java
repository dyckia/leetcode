class Solution {
    public int missingNumber(int[] nums) {
        boolean[] visited = new boolean[nums.length + 1];
        for (int num : nums) {
            visited[num] = true;
        }

        int missN = 0;

        // to nums.length + 1 since one number is missing
        while (missN < nums.length + 1) {
            if (!visited[missN]) return missN;
            missN++;
        }
        
        return missN;
    }
}

/*
Time: O(n)

Space: O(n)
*/