// compute count while scanning the array (+1 if value is 1, -1 if value is 0)
// if a subarray has equal number of 0 and 1
// the count at the start index and end index must be the same
// use array to store the start index (could have 2n + 1 possibile values)

class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int max = 0;
        int count = 0;
        // store start index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < len; i++) {
            count += (nums[i] == 0) ? -1 : 1;

            if (!map.containsKey(count)) {
                map.put(count, i);
            } else {
                max = Math.max(max, i - map.get(count));
            }
        }

        return max;
    }
}