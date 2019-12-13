class Solution {
    public int numDecodings(String s) {
        // since s is non-empty, we don't need to check if s.length() == 0
        if (s == null) return 0;

        Integer[] memo = new Integer[s.length() + 1];
        memo[memo.length - 1] = 1;
        return helper(s, 0, memo);
    }
    
    // return the number of ways to decode the substring s.substring(start)
    private int helper(String s, int start, Integer[] memo) {
        if (memo[start] != null) return memo[start];

        if (s.charAt(start) == '0') {
            memo[start] = 0;
            return memo[start];
        } 
        
        // current digit is between 1 and 9, must can be decoded
        int num = helper(s, start + 1, memo);
        
        // if remaining characters is greater than 2 and 
        // that two digit value is less than 26
        if (start <= s.length() - 2 && 
            Integer.parseInt(s.substring(start, start + 2)) <= 26) {
            num += helper(s, start + 2, memo);
        }
        
        memo[start] = num;
        return memo[start];
    }
}

/*
Time: O(n)

Space: O(n)
*/