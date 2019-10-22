class Solution {
    public int subarraySum(int[] nums, int k) {
        
        // given an index j and its cummulative sum[0, j] (sum from 0 to j)
        // if i < j and sum[0, i] + k = sum[0, j]
        // then the subarray [i + 1, j] must be the the subarray we want
        
        // use hashMap to stroe all cummulative sums and their frequency
        
        HashMap<Integer, Integer> sums = new HashMap<>();
        // start from the very beginning 
        sums.put(0, 1);
        
        int count = 0;
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int frequency = sums.getOrDefault(sum, 0) + 1;
            if (sums.containsKey(sum - k)) {
                count += sums.get(sum - k);
            }
            sums.put(sum, frequency);
        }
        
        return count;
    }
}

/*
Time: O(n)

Space: O(n)
*/