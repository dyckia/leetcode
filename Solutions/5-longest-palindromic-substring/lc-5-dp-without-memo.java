class Solution {
    // since string(i, j) only depends on string(i + 1, j - 1)
    // we can remove memo
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // odd pal string
            String str1 = extendPalindrome(s, i, i);
            // even pal string
            String str2 = extendPalindrome(s, i, i + 1);

            res = str1.length() > res.length() ? str1 : res;
            res = str2.length() > res.length() ? str2 : res;
        }
        return res;
    }
    
    private String extendPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        // last mactched index is i + 1 and j - 1
        // if j == s.length() return empty string
        // if i + 1 == j return empty string
        return s.substring(i + 1, j);
    }
}