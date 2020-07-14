class Solution {
    public boolean isPowerOfThree(int n) {
        // convert from ten-based to three-based
        // check if matches 10000... using regex
        
        String baseThree = Integer.toString(n, 3);
        
        return baseThree.matches("^10*$");
    }
}

/*
Time: log3(n)
Base conversion is generally implemented as a repeated division.

Space: log3(n)
string length is log3(n)
*/