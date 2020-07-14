class Solution {
    public boolean isPowerOfThree(int n) {
        // in java, the max int value is 2^32 / 2 - 1 
        // so the largest power of 3 number is 1162261467
        // check whether maxPower is divisible by n
        
        return n > 0 && 1162261467 % n == 0;
    }
}

/*
Time: 1

Space: 1
*/