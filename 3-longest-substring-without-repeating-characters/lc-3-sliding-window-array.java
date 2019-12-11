// use array instead of HashMap
// array to store the index of the next character after current character


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxL = 0;
        int[] ind = new int[128];

        for (int start = 0, end = 0; end < s.length(); end++) {
            // we can access by using arr[char]
            start = Math.max(ind[s.charAt(end)], start);
            maxL = Math.max(maxL, end - start + 1);
            ind[s.charAt(end)] = end + 1;
        }

        return maxL;
    }
}