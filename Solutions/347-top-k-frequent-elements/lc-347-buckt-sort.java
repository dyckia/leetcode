class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // since the range of count is fixed (0, nums), we can use buckt sort
        // count frequency
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n : nums) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }

        // create one bucket for each frequency
        // each bucket is a list of n for that frequency
        // NOTE: no <> after new List[]
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int n : counts.keySet()) {
            int count = counts.get(n);
            // default vaule for object is null
            if (bucket[count] == null) bucket[count] = new ArrayList<>();
            bucket[count].add(n);
        }

        // scan each bucket and add to res
        int[] res = new int[k];
        int j = 0;
        for (int i = nums.length; i >= 0; i--) {
            if (bucket[i] == null) continue;
            for (int n : bucket[i]) {
                res[j++] = n;
                if (j == k) return res;
            }
        }

        return res;
    }
}

/*
Time: n

Space: n
*/