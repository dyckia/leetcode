class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char cur = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                // stop at the shortest string or first unmatched char
                if (i == strs[j].length() || strs[j].charAt(i) != cur) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}

/*
Time: O(S)
S is the sum of all characters in the strs array

Space: O(1)
*/