public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // 001011 -> 110100
        // get bits from right to left
        // use & and mask 1 to keep the right most bit
        // 001001 & 000001 -> 000001
        
        // unsigned integer has 32 bits        
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // must shift res first otherwise we will lose the first bit
            res <<= 1;
            res = res + (n & 1);
            n >>= 1;
        }
        
        return res;
    }
}

/*
Time: 1

Space: 1

Follow-up: If this function is called many times, how would you optimize it?
Reverse byte by byte and store reversed byte in memo
*/

*/