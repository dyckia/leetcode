public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // 001011 -> 110100
        // use & and mask 1 to check the right most bit
        // 001001 & 000001 -> 000001
        
        int res = 0;
        
        for (int i = 0; i < 32; i++) {
            // must use parenthese as priority of == is higher than &
            if ((n & 1) == 1) res++;
            n >>= 1;
        }
        
        return res;
    }
}

/*
Time: 1

Space: 1
*/