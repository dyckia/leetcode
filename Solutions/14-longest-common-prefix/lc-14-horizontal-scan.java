class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        StringBuilder prefix = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            int ind = firstUnmatchedInd(strs[i], prefix);
            // delete from ind to the end
            prefix.delete(ind, prefix.length());
        }

        return prefix.toString();
    }

    private int firstUnmatchedInd(String s, StringBuilder prefix) {
        int ind = 0;
        while (ind < s.length() && ind < prefix.length() && s.charAt(ind) == prefix.charAt(ind)) {
            ind++;
        }
        return ind;
    }
}

/*
solution using built-in methods

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String curStr = strs[i];
            while (curStr.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }
}
*/

/*
Time: O(S)
S is the sum of all characters in the strs array

Space: O(1)
*/