class Solution {
    // since string(i, j) only depends on string(i + 1, j - 1)
    // we can remove memo
    public String longestPalindrome(String s) {
        int start = 0,
            maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            // odd pal string
            int len1 = extendPalindrome(s, i, i);
            // even pal string
            int len2 = extendPalindrome(s, i, i + 1);

            int curLen = Math.max(len1, len2);
            if (curLen > maxLen) {
                // start index is i - (curLen - 1) / 2
                // end index is i + curLen / 2
                start = i - (curLen - 1) / 2;
                maxLen = curLen;
            }
        }
        return s.substring(start, start + maxLen);
    }
    
    // returns length
    private int extendPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        // last mactched index is i + 1 and j - 1
        // if j == s.length() return empty string
        // if i + 1 == j return empty string
        return j - i - 1;
    }
}