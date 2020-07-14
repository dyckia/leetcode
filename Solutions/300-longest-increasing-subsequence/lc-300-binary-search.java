class Solution {
    public int lengthOfLIS(int[] nums) {
        // tails store the minimum end value of LIT of given length
        // tails[i] = k -> for any LITs in length i, the lowest end value is k
        // max LIT length is nums.length
        int[] tails = new int[nums.length + 1];
        // actual size of the tails array
        int size = 0;
        for (int n : nums) {
            // r is acutual right boundary + 1
            int l = 1, r = size + 1;
            // tails array must be increasing
            // find the lowest index whose value is greater than n
            // if not store n in tails[size + 1]
            while (l != r) {
                int mid = (l + r) / 2;
                if (tails[mid] >= n) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            tails[r] = n;
            // n is greater than all tails, increase size
            if (r == size + 1) size++;
        }
        
        return size;
    }
}