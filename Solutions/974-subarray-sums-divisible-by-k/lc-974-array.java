class Solution {
    public int subarraysDivByK(int[] A, int K) {
        // problem is similar to 560 Subarray Sum Equals K
        // use an array to store the frequency of remainder of prefix sums divided by k
        // index - remainder of prefix divided by k
        // value - its frequency
        
        // (prefixCur - prefixPrev) % k == 0  ->  prefix % k == prefixPrev % k  (given prefix >= 0)
        
        // since we only concern about the remainder not the prefix 
        // we can store prefixRemainder directly
        
        // since remainder has a finite range
        // we can store the frequency inside an array instead of a map
        
        int[] freq = new int[K];
        freq[0] = 1;
        int prefixRemainder = 0,
            count = 0;
        
        for (int a : A) {
            // makes remainder always >= K
            prefixRemainder = (prefixRemainder + a % K + K) % K;
            count += freq[prefixRemainder];
            freq[prefixRemainder]++;
        }
        
        return count;
    }
}

/*
Time: O(n)

Space: O(n)
*/