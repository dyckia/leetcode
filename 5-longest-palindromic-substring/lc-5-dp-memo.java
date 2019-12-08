class Solution {
    // if substring from i to j is palindromic
    // 0 unknown, 1 true, -1 false
    int[][] memo;
    
    public String longestPalindrome(String s) {
        memo = new int[s.length()][s.length()];
        String res = "";
        
        for (int i = 0; i < s.length(); i++) {
            for (int k = i; k < s.length(); k++) {
                if (isPalindromic(s, i, k) && k - i + 1 > res.length()) {
                    res = s.substring(i, k + 1);
                }
            }
        }
        
        return res;
    }
    
    private boolean isPalindromic(String s, int i, int k) {
        if (memo[i][k] != 0) return (memo[i][k] == 1) ? true : false;
                
        boolean isPal = s.charAt(i) == s.charAt(k);
        if (k - i > 1) isPal = isPal && isPalindromic(s, i + 1, k - 1);
        
        memo[i][k] = isPal ? 1 : -1;
        
        return isPal;
    }
}