class Solution {
    public boolean isPowerOfThree(int n) {
        // the problem is same to check if log3(n) is integer
        // log3(n) = log10(n) / log10(3)
        // Math.log() returns double so be careful about precision error
        
        return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
    }
}

/*
Time: Unknown
Depends on how Math.log is implemented.

Space: 1
*/