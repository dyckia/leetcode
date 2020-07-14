class Solution {
    public int subarraysDivByK(int[] A, int K) {
        // problem is similar to 560 Subarray Sum Equals K
        // use an array to store the frequency of remainder of prefix sums divided by k
        // index - remainder of prefix divided by k
        // value - its frequency
        
        // (prefixCur - prefixPrev) % k == 0  ->  prefix % k == prefixPrev % k  (given prefix >= 0)
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        int prefix = 0,
            count = 0;
        
        for (int a : A) {
            
            prefix += a;
            // makes remainder always >= 0
            int remainder = (prefix % K + K) % K;
            count += freq.getOrDefault(remainder, 0);
            freq.put(remainder, freq.getOrDefault(remainder, 0) + 1);
        }
        
        return count;
    }
}

/*
Time: O(n)

Space: O(n)
*/